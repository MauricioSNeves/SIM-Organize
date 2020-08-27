import React from 'react'
import {
    Tr,
    Table,
    Touch,
    TableH,
    TableHead,
} from './styles'

import { FiCheck } from "react-icons/fi";
import { colors } from '~/styles';


const TableTemplate = () => {
    
    const assinaturas = [
        "Checklist",
        "4dx",
        "Mais de uma Skin"
    ]
    return (
          
                <Table>
                    <TableHead>
                <tr>
                            <TableH width="15%"></TableH>
                            <TableH width="15%">Free</TableH>
                            <TableH width="15%" >Premium</TableH>
                            <TableH width="15%">Organize</TableH>
                        </tr>
                    </TableHead>
                    <tbody>
                {assinaturas.map((ass )=> {
                    return (
                        <Tr>
                            <TableH>{ass}</TableH>
                            <TableH>
                                <Touch>
                                    <FiCheck  size={25} color={colors.green} />
                                </Touch>
                            </TableH>
                            <TableH>
                                <Touch align="center" >
                                    <FiCheck size={25} color={colors.green} />
                                </Touch>
                            </TableH>
                            <TableH align="left">
                                <Touch>
                                    <FiCheck size={25} color={colors.green} />
                                </Touch>
                            </TableH>
                        </Tr> 
                          )
                      })}  
                    </tbody>
                </Table>

    )
}

export default TableTemplate;