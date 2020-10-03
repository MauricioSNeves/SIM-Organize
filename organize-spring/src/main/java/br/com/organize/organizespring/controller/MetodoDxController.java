package br.com.organize.organizespring.controller;

import br.com.organize.organizespring.dto.*;
import br.com.organize.organizespring.dto.TarefaMdDoisDto;
import br.com.organize.organizespring.form.*;
import br.com.organize.organizespring.model.*;
import br.com.organize.organizespring.repository.*;
import br.com.organize.organizespring.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.io.*;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/metodosdxs")
public class MetodoDxController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MetodoDxRepository metodoDxRepository;

    @Autowired
    private TarefaMdDoisRepository tarefaMdDoisRepository;

    @Autowired
    private TarefaMdUmRepository tarefaMdUmRepository;

    @Autowired
    private MdDoisRepository mdDoisRepository;

    @Autowired
    private MdUmRepository mdUmRepository;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity listarQuatroDx(Authentication authentication) {
        List<MetodoDx> metodosDxs = metodoDxRepository.todosOsQuatroDx(usuarioService.usuarioAtual(authentication));
        return ResponseEntity.ok(metodosDxs);
    }

    @GetMapping("/4dx/{id}")
    public ResponseEntity listarAtualQuatroDx(@PathVariable("id") Integer id) {
        List<Object> lista = new ArrayList<>();
        lista.add(metodoDxRepository.findById(id));
        lista.add(mdUmRepository.mdUm(id));
        lista.add(mdDoisRepository.mdDois(id));

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/tarefas/{id}")
    public ResponseEntity listarTarefas(@PathVariable("id") Integer id) {
        List<Object> lista = new ArrayList<>();
        lista.add(metodoDxRepository.findById(id));

        if (tarefaMdDoisRepository.tarefaExistente(id) != null && tarefaMdUmRepository.tarefaExistente(id) != null) {
            lista.add(tarefaMdDoisRepository.listaTarefasMd(mdDoisRepository.mdDois(id).getIdMdDois()));
            lista.add(tarefaMdUmRepository.listaTarefasMd(mdUmRepository.mdUm(id).getIdMdUm()));

            return ResponseEntity.ok(lista);
        }

        return ResponseEntity.notFound().build();
    }


    @PostMapping("/4dx")
    public ResponseEntity<MetodoDxDto> criaQuatroDx(@RequestBody MetodoDxForm form, UriComponentsBuilder uriBuilder, Authentication authentication) {
        MetodoDx metodoDx = form.converter();
        Usuario usuario = usuarioRepository.getOne(usuarioService.usuarioAtual(authentication));
        metodoDx.setUsuario(usuario);

        LocalDate dataAtual = LocalDate.now();
        System.out.println(dataAtual);

        LocalDate dataConclusao = metodoDx.getDataConclusaoDx();
        System.out.println(dataConclusao);

        long diferencaEmDias = ChronoUnit.DAYS.between(dataAtual, dataConclusao);
        long semanas = diferencaEmDias / 7;

        metodoDx.setSemanas(semanas);

        metodoDxRepository.save(metodoDx);

        URI uri = uriBuilder.path("/metodosdxs/4dx/{id}").buildAndExpand(metodoDx.getIdMetodoDx()).encode().toUri();
        return ResponseEntity.created(uri).body(new MetodoDxDto(metodoDx));
    }

    @DeleteMapping("/4dx/{id}")
    @Transactional
    public ResponseEntity<?> deletaQuatroDx(@PathVariable("id") Integer id) {
        Optional<MetodoDx> optional = metodoDxRepository.findById(id);
        if (optional.isPresent()) {

            Integer mdUm = mdUmRepository.mdUm(id).getIdMdUm();
            Integer mdDois = mdDoisRepository.mdDois(id).getIdMdDois();

            if (tarefaMdDoisRepository.tarefaExistente(mdUm) != null && tarefaMdUmRepository.tarefaExistente(mdDois) != null) {
                tarefaMdUmRepository.deletaTarefa(mdUmRepository.mdUm(id).getIdMdUm());
                tarefaMdDoisRepository.deletaTarefa(mdDoisRepository.mdDois(id).getIdMdDois());
            }

            mdDoisRepository.deletaMd(id);
            mdUmRepository.deletaMd(id);
            metodoDxRepository.deleteById(id);

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/4dx/{id}/mdUm")
    public ResponseEntity<MdUmDto> cadastraMdUm(@RequestBody MdUmForm form, @PathVariable("id") Integer id, UriComponentsBuilder uriBuilder, Authentication authentication) {
        MdUm mdUm = form.converter();
        MetodoDx metodoDx = metodoDxRepository.getOne(id);
        mdUm.setMetodoDx(metodoDx);
        mdUmRepository.save(mdUm);
        URI uri = uriBuilder.path("/metodosdxs/4dx/mdum/{idMdUm}").buildAndExpand(mdUm.getIdMdUm()).toUri();
        return ResponseEntity.created(uri).body(new MdUmDto(mdUm));
    }

    @PostMapping("/4dx/{id}/mddois")
    public ResponseEntity<MdDoisDto> cadastraMdDois(@RequestBody MdDoisForm form, @PathVariable("id") Integer id, UriComponentsBuilder uriBuilder, Authentication authentication) {
        MdDois mdDois = form.converter();
        MetodoDx metodoDx = metodoDxRepository.getOne(id);
        mdDois.setMetodoDx(metodoDx);
        mdDoisRepository.save(mdDois);
        URI uri = uriBuilder.path("/metodosdxs/4dx/mddois/{idMdDois}").buildAndExpand(mdDois.getIdMdDois()).toUri();
        return ResponseEntity.created(uri).body(new MdDoisDto(mdDois));
    }

    @PostMapping("/4dx/{idDx}/mdUm/{idMd}")
    public ResponseEntity<TarefaMdUmDto> cadastraTarefasMdUm(@RequestBody TarefaMdUmForm form, @PathVariable("idDx") Integer idDx, @PathVariable("idMd") Integer idMd, UriComponentsBuilder uriBuilder, Authentication authentication) {
        TarefaMdUm tarefaMdUm = form.converter();
        MdUm mdUm = mdUmRepository.getOne(idMd);
        tarefaMdUm.setMdUm(mdUm);
        tarefaMdUmRepository.save(tarefaMdUm);
        URI uri = uriBuilder.path("/metodosdxs/4dx/mdum/tarefa/{id}").buildAndExpand(tarefaMdUm.getIdTarefaMdUm()).toUri();
        return ResponseEntity.created(uri).body(new TarefaMdUmDto(tarefaMdUm));
    }

    @PostMapping("/4dx/{idDx}/mdDois/{idMd}")
    public ResponseEntity<TarefaMdDoisDto> cadastraTarefasMdDois(@RequestBody TarefaMdDoisForm form, @PathVariable("idDx") Integer idDx, @PathVariable("idMd") Integer idMd, UriComponentsBuilder uriBuilder, Authentication authentication) {
        TarefaMdDois tarefaMdDois = form.converter();
        MdDois mdDois = mdDoisRepository.getOne(idMd);
        tarefaMdDois.setMdDois(mdDois);
        tarefaMdDoisRepository.save(tarefaMdDois);
        URI uri = uriBuilder.path("/metodosdxs/4dx/mddois/tarefa/{id}").buildAndExpand(tarefaMdDois.getIdTarefaMdDois()).toUri();
        return ResponseEntity.created(uri).body(new TarefaMdDoisDto(tarefaMdDois));
    }

    @PutMapping("/tarefa/md1/{idTarefa}")
    @Transactional
    public ResponseEntity<TarefaMdDoisDto> atualizaStatusDois(@PathVariable("idTarefa") Integer idTarefa, @RequestBody Boolean status) {
        TarefaMdDois tarefa = tarefaMdDoisRepository.getOne(idTarefa);
        tarefa.setStatusMdDois(status);
        tarefaMdDoisRepository.save(tarefa);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/tarefa/md2/{idTarefa}")
    @Transactional
    public ResponseEntity<TarefaMdUmDto> atualizaStatusUm(@PathVariable("idTarefa") Integer idTarefa, @RequestBody Boolean status) {
        TarefaMdUm tarefa = tarefaMdUmRepository.getOne(idTarefa);
        tarefa.setStatusMdUm(status);
        tarefaMdUmRepository.save(tarefa);
        return ResponseEntity.ok().build();
    }


//    EXPORTAR E IMPORTAR ABAIXO


    @PostMapping("/exportar/{id}")
    public ResponseEntity exportar(@PathVariable Integer id) {

        if (metodoDxRepository.existsById(id)) {
            Optional<MetodoDx> metodoDx = metodoDxRepository.findById(id);

            String mdUm = mdUmRepository.mdUm(id).getNomeMetaMdUm();
            String mdDois = mdDoisRepository.mdDois(id).getNomeMetaMdDois();

            String arqTotal = "";
            String nomeArq = "arquivoMetodoDx.txt";
            String header = "";
            String corpo = "";
            String trailer = "";

            // Monta o registro header
            Date dataDeHoje = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            header += "00METODODX20201";
            header += formatter.format(dataDeHoje);
            header += "01";

            // Grava o registro header
//            gravaRegistro(nomeArq, corpo);
            arqTotal += header + "\n";


            // Monta o corpo

//            Tipo do registro
            corpo += "02";
//            Id do método dx
            corpo += String.format("%-8s", metodoDx.get().getIdMetodoDx());
//            Nome do metodo dx
            corpo += String.format("%-40s", metodoDx.get().getNomeDx());
//        Data de conclusao
            corpo += String.format("%-10s", metodoDx.get().getDataConclusaoDx());
//            Nome da mci
            corpo += String.format("%-40s", metodoDx.get().getNomeMci());
//            Nome da md um
            corpo += String.format("%-40s", mdUm);
//            Nome da md dois
            corpo += String.format("%-40s", mdDois);
//            Semanas para concluir
            corpo += String.format("%-2d", metodoDx.get().getSemanas());
//            Data inicio
            corpo += String.format("%-10s", metodoDx.get().getDataInicioDx());

//            gravaRegistro(nomeArq, corpo);
            arqTotal += corpo + "\n";



            // monta o trailer
            trailer += "03";
            trailer += String.format("%010d", 1);
            arqTotal += trailer;
            gravaRegistro(nomeArq, arqTotal);
//            gravaRegistro(nomeArq, trailer);

            return ResponseEntity.created(null).build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/gravar-registro")
    public void gravaRegistro(String nomeArq, String registro) {
        BufferedWriter saida = null;
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, false));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        try {
            saida.append(registro + "\n");
            saida.close();

        } catch (IOException e) {
            System.err.printf("Erro ao gravar arquivo: %s.\n", e.getMessage());
        }
    }


    @GetMapping("/ler")
    public void ler(String nomeArq, Authentication authentication, UriComponentsBuilder uriBuilder) {
        BufferedReader entrada = null;
        String registro;
        String tipoRegistro;

        String nomeDx, dataConclusaoDx, nomeMci, mdUm, mdDois, semanas, dataInicioDx;


        int contRegistro = 0;

        // Abre o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        // Lê os registros do arquivo
        try {
            // Lê um registro
            registro = entrada.readLine();

            while (registro != null) {
                // Obtém o tipo do registro
                tipoRegistro = registro.substring(0, 2); // obtém os 2 primeiros caracteres do registro

                if (tipoRegistro.equals("00")) {
                    System.out.println("Header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 10));
                    int periodoLetivo = Integer.parseInt(registro.substring(10, 15));
                    System.out.println("Período letivo: " + periodoLetivo);
                    System.out.println("Data/hora de geração do arquivo: " + registro.substring(15, 34));
                    System.out.println("Versão do layout: " + registro.substring(34, 36));

                } else if (tipoRegistro.equals("01")) {
                    System.out.println("\nTrailer");
                    int qtdRegistro = Integer.parseInt(registro.substring(2, 12));
                    if (qtdRegistro == contRegistro) {
                        System.out.println("Quantidade de registros gravados compatível com quantidade lida");
                    } else {
                        System.out.println("Quantidade de registros gravados não confere com quantidade lida");
                    }

                } else if (tipoRegistro.equals("02")) {
                    if (contRegistro == 0) {
                        System.out.println();
                        System.out.printf("%-16s %-40s %-10s %-40s %-40s %-40s %2s %10s\n",
                                "TIPO DO REGISTRO", "NOME DX", "DATA CONCLUSÃO", "NOME MCI", "NOME MD UM", "NOME MD DOIS", "SEMANAS", "DATA INICIO");

                    }

                    tipoRegistro = registro.substring(0, 2);

//                  QUATRO DX
                    nomeDx = registro.substring(10, 50);
                    dataConclusaoDx = registro.substring(50, 60);
                    nomeMci = registro.substring(60, 100);

                    mdUm = registro.substring(100, 140);
                    mdDois = registro.substring(140, 180);

//                  QUATRO DX
                    semanas = registro.substring(180, 182);
                    dataInicioDx = registro.substring(182, 192);

                    MetodoDxForm metodoDxForm = new MetodoDxForm();
                    metodoDxForm.setNomeDx(nomeDx);
                    metodoDxForm.setDataConclusaoDx(LocalDate.parse(dataConclusaoDx));
                    metodoDxForm.setNomeMci(nomeMci);

//                    criaQuatroDx(metodoDxForm, uriBuilder, authentication);

                    MetodoDx metodoDx = metodoDxForm.converter();
                    Usuario usuario = usuarioRepository.getOne(usuarioService.usuarioAtual(authentication));
                    metodoDx.setUsuario(usuario);
                    LocalDate dataAtual = LocalDate.now();
                    LocalDate dataConclusao = metodoDx.getDataConclusaoDx();
                    long diferencaEmDias = ChronoUnit.DAYS.between(dataAtual, dataConclusao);
                    long semana = diferencaEmDias / 7;
                    metodoDx.setSemanas(semana);
                    metodoDxRepository.save(metodoDx);

                    MdUmForm mdUmForm = new MdUmForm();
                    mdUmForm.setNomeMetaMdUm(mdUm);

                    MdUm mdUmModel = mdUmForm.converter();
                    mdUmModel.setMetodoDx(metodoDx);
                    mdUmRepository.save(mdUmModel);

                    MdDoisForm mdDoisForm = new MdDoisForm();
                    mdDoisForm.setNomeMetaMdDois(mdDois);
                    MdDois mdDoisModel = mdDoisForm.converter();
                    mdDoisModel.setMetodoDx(metodoDx);
                    mdDoisRepository.save(mdDoisModel);

//                    System.out.println("-------------------------------------------------------------------------------------------" + metodoDxRepository.ultimoQuatroDx(nomeDx));

//                    cadastraMdUm(mdUmForm, (metodoDxRepository.ultimoQuatroDx(nomeDx)), uriBuilder, authentication);
//                    cadastraMdDois(mdDoisForm, (metodoDxRepository.ultimoQuatroDx(nomeDx)), uriBuilder, authentication);

//                    System.out.printf("%-16s %-40s %-10s %-40s %-40s %-40s %2s %10s\n", tipoRegistro, nomeDx, dataConclusaoDx, nomeMci, mdUm, mdDois, semanas, dataInicioDx);

                    contRegistro++;
                } else {
                    System.out.println("Tipo de registro inválido");
                }

                // lê o próximo registro
                registro = entrada.readLine();
            }

            // Fecha o arquivo
            entrada.close();
        } catch (IOException e) {
            System.err.printf("Erro ao ler arquivo: %s.\n", e.getMessage());
        }
    }

    @GetMapping("/importar")
    public ResponseEntity importarPo(Authentication authentication, UriComponentsBuilder uriBuilder) {

        String nomeArq = "arquivoMetodoDx.txt";

        File arquivo = new File(nomeArq);
        if (arquivo.exists()) {
            ler(nomeArq, authentication, uriBuilder);
            return ResponseEntity.created(null).build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}