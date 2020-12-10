package br.com.organize.organizespring.config.sercurity;

import br.com.organize.organizespring.repository.UsuarioRepository;
import br.com.organize.organizespring.service.AutenticacaoService;
import br.com.organize.organizespring.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private TokenService tokenService;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                .antMatchers(HttpMethod.POST, "/usuarios").permitAll()
                .antMatchers(HttpMethod.GET, "/usuarios/confirmar-conta/*").permitAll()
                .antMatchers(HttpMethod.GET, "/usuarios/exportar").permitAll()
                .antMatchers(HttpMethod.GET, "/usuarios/importar").permitAll()

                .antMatchers(HttpMethod.GET, "/h2-console/**").permitAll()
                .antMatchers(HttpMethod.POST, "/h2-console/**").permitAll()

                .antMatchers(HttpMethod.POST, "/checklists/tarefa").permitAll()
                .antMatchers(HttpMethod.PUT, "/checklists/tarefa/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE, "/checklists/tarefa/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/checklists/").permitAll()

                .antMatchers(HttpMethod.GET, "/metodosdxs/").permitAll()
                .antMatchers(HttpMethod.GET, "/metodosdxs/4dx/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/metodosdxs/tarefas/{id}").permitAll()

                .antMatchers(HttpMethod.POST, "/metodosdxs/4dx").permitAll()
                .antMatchers(HttpMethod.POST, "/metodosdxs/4dx").permitAll()
                .antMatchers(HttpMethod.DELETE, "/metodosdxs/4dx/{id}").permitAll()
                .antMatchers(HttpMethod.POST, "/metodosdxs/4dx/{id}/mdUm").permitAll()
                .antMatchers(HttpMethod.POST, "/metodosdxs/4dx/{id}/mddois").permitAll()
                .antMatchers(HttpMethod.POST, "/metodosdxs/4dx/{idDx}/mdUm/{idMd}").permitAll()
                .antMatchers(HttpMethod.POST, "/metodosdxs/4dx/{idDx}/mdDois/{idMd}").permitAll()
                .antMatchers(HttpMethod.PUT, "/metodosdxs/tarefa/md1/{idTarefa}").permitAll()
                .antMatchers(HttpMethod.PUT, "/metodosdxs/tarefa/md2/{idTarefa}").permitAll()
                .antMatchers(HttpMethod.GET, "/metodosdxs/meses/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/metodosdxs/meses").permitAll()
                .antMatchers(HttpMethod.POST, "/metodosdxs/exportar/{id}").permitAll()
                .antMatchers(HttpMethod.GET, "/metodosdxs/gravar-registro").permitAll()
                .antMatchers(HttpMethod.GET, "/metodosdxs/ler").permitAll()
                .antMatchers(HttpMethod.GET, "/metodosdxs/importar").permitAll()

                .anyRequest().authenticated()
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new AutenticacaoFilter(tokenService, repository), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    //TIRAR
    //Outros comentários
}