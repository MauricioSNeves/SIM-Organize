import styled from 'styled-components';

import { colors, metrics } from '~/styles';

import { AlignVertically } from '~/styles/globalComponents/AlignVertically/styles'
import { AlignHorizontally } from '~/styles/globalComponents/AlignHorizontally/styles'
import { PageTitleTemplate } from '~/styles/globalComponents/PageTitleTemplate/styles'
import { ContainerWhite } from '~/styles/globalComponents/ContainerWhite/styles'

import image4dx from '~/assets/image4dx.png'

export const AlignV = styled(AlignVertically)`
    justify-content:center;
    max-height:${props=>props.height ? 600 : "unset"}px;
`;

export const Container = styled(ContainerWhite)`
    height:unset;
    width:190px;
    padding:10px;
    margin:10px;
`;

export const AlignH = styled(AlignHorizontally)`
    min-height:calc(94vh - 70px);
    width:100%;
    /* border:10px solid; */
`;



export const AlignHX = styled(AlignHorizontally)`
    width:30%;
    justify-content: space-between;

    /* border:10px solid; */
`;
export const AlignHo = styled(AlignHorizontally)`
    width:100%;
    justify-content: space-between;
    overflow:inherit;
    flex-flow:${props => props.mds ? "unset" : "row wrap"};

`;

export const PageTitle = styled(PageTitleTemplate)`
    position: absolute;
    top:120px;
    margin-bottom:0px;  
    color:${colors.primaryWhite};
`;

export const Suport = styled.div`
    text-align:center;
`;


export const Func = styled.div`
    margin:10px ;
    &:hover{
        /* color:${colors.primary} */
        background-color:${colors.primary}
    }
    cursor:pointer;
    border: 1px solid rgba(61, 57, 63, 0.96);
    border-radius:4px;
    padding:10px;
`;

export const Mds = styled(PageTitleTemplate)`
    font-size:${metrics.fontSize.extraMedium}px;
    color:${colors.primaryWhite};
`;

export const Foot = styled.div`
    height:80px;
`;

export const Body = styled.div`
    margin-left:75px;
    padding:2px;
    background-image:url(${image4dx});
    background-repeat:no-repeat;
    background-size:cover;
    color:${colors.primaryWhite};
`;

export const Img = styled.img`
`;
export const SuplementarText = styled.h2`
    /* margin-top:60px; */
    margin-bottom:20px;
    color: ${colors.gray};
    font-weight: 300;
    font-style: normal;
    font-size:${metrics.fontSize.big}px;
`;

export const Text = styled.p`
    font-weight: 700;
    font-style: normal;
    font-size:14px;
    margin-top:0.5em;
    text-align:center;
`;