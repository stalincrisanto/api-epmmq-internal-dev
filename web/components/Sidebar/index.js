import React, { useState, useEffect } from "react";
import axios from "axios";

import styled from "styled-components";
import Link from 'next/link'
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import { IconContext } from "react-icons/lib";
import { IoIosArrowDown } from "react-icons/io";

import {SubMenu} from "./SubMenu";
import "./Sidebar.css";

const Nav = styled.div`
  background: #154192ff;
  height: 96px;
  display: flex;
  justify-content: space-around;
  align-items: center;
  position: relative;
  color: white;
  background-image: url('../imagenes/banerLargo.jpg');
`;
  
const NavIcon = styled(Link)`
  margin-left: 1rem;
  font-size: 1rem;
  height: 14px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  left: 0;
`;
  
const SidebarNav = styled.nav`
  background: #2653b4ff;
  opacity:0.93;
  width: 280px;
  height: calc(100vh - 96px);
  display: flex;
  justify-content: center;
  position: fixed;
  top: 96px;
  left: ${(props) => (props.sidebar ? "0" : "-100%")};
  transition: 350ms;
  z-index: 10;
`;
  
const SidebarWrap = styled.div`
  width: 100%;
`;
  
const Sidebar = ({titulo, baseUrl, empresa, rol}) => {
const [sidebar, setSidebar] = useState(false);
const [sidebarDb, setSidebarDb] = useState([]);

  const showSidebar = () => setSidebar(!sidebar);
  

  useEffect(() => {
    axios.get(baseUrl + '/menu/' + rol)
    .then( response => {
      console.log('Datos del menu:',response.data);
      setSidebarDb(response.data);
    })
    .catch(error =>{
        alert('Error detectado:', {error}); 
        setSidebarDb([]);
    });
  }, [empresa, rol]);
  
  return (
    <>
      <IconContext.Provider className="Sidebar-Icon" value={{ color: "#fff" }}>
        <Nav>
          <NavIcon href="#">
            <FaIcons.FaBars onClick={showSidebar} />
          </NavIcon>
          <h1 className="Sidebar-h1">
            {titulo}
          </h1>
          <a href="/login">Conectarse</a>
          {/*<img className="SidebarImg" src="../imagenes/banerLargo.jpg" alt="Cedco Salud"/>*/}
        </Nav>
        <SidebarNav sidebar={sidebar}>
          <SidebarWrap>
            <NavIcon href="#">
              <AiIcons.AiOutlineCloseCircle onClick={showSidebar} />
            </NavIcon>
            {
              sidebarDb&&sidebarDb.map((item, index) => {
              return <SubMenu item={item} key={index} />;
            })
            }
          </SidebarWrap>
        </SidebarNav>
      </IconContext.Provider>
    </>
  );
};
  
export default Sidebar;