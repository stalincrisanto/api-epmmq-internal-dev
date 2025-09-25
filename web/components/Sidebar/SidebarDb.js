
import axios from 'axios';

const traeSidebarDb = ({empresa, rol}) => {
    const urlMenu = `http://localhost:3001/awasalud/api/menurol/menu/${empresa}/${rol}`;
    axios({
        url:    urlMenu,
        method: 'get',
    })
    .then( response => {
        return response.data;
    })
    .catch(error =>{
        alert('Error detectado:', error.response.data); 
        return [];
    });
}

export { traeSidebarDb };