//import { Link } from "react-router-dom";
import Link from 'next/link';
import React, { useState } from "react";
import styled from "styled-components";
  
import * as FaIcons from "react-icons/fa";

const SidebarLink = styled(Link)`
  display: flex;
  color: white;
  justify-content: space-between;
  align-items: center;
  padding: 1px;
  list-style: none;
  height: 50px;  
  text-decoration: none;
  font-size: 12px;   
  border-radius: 2px;
  border: 2px solid #bbd7e2ff;

  &:hover {
    background: blue;  
    border-left: 0px solid PowderBlue;
    cursor: pointer;
  }
`;
  
const SidebarLabel = styled.span`
  margin-left: 16px;
`;
  
const DropdownLink = styled(Link)`
  background: #2912bcff;  
  height: 28px;
  padding-left: 2rem;
  display: flex;
  align-items: center;
  text-decoration: none;
  color: yellow;
  font-size: 12px; 
  
  &:hover {
    background: #4720a4ff;
    cursor: pointer;
  }
`;
  
const SubMenu = ({ item }) => {
  const [subnav, setSubnav] = useState(false);
  
  const showSubnav = () => setSubnav(!subnav);
  
  return (
    <>
      <SidebarLink href={item.path} 
      onClick={item.subNav && showSubnav}>
        <div>
          {item.icon}
          <SidebarLabel>{item.title}</SidebarLabel>
        </div>
        <div className="Submenu-icons">
          {item.subNav && subnav
            ? item.iconOpened
            : item.subNav
            ? item.iconClosed
            : null}
        </div>
      </SidebarLink>
      {subnav &&
        item.subNav.map((item, index) => {
          return (
            <DropdownLink href={item.path} key={index}>
              {item.icon}
              <SidebarLabel>{item.title}</SidebarLabel>
            </DropdownLink>
          );
        })}
    </>
  );
};
  
export  {SubMenu};