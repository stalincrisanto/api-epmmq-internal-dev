'use client';
//import type { Metadata } from "next";
import { Geist, Geist_Mono } from "next/font/google";
import Sidebar from "../components/Sidebar";


import "./globals.css";

const geistSans = Geist({
  variable: "--font-geist-sans",
  subsets: ["latin"],
});

const geistMono = Geist_Mono({
  variable: "--font-geist-mono",
  subsets: ["latin"],
});

/*
export const metadata: Metadata = {
  title: "Metro de Quito",
  description: "SCR Metro de Quito",
};*/

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode;
}>) {
  return (
    <html lang="en">
      <body
        className={`${geistSans.variable} ${geistMono.variable} antialiased`} 
      >
        <Sidebar titulo ="Metro de Quito" empresa={1} rol = {2}  baseUrl={"http://localhost:8088/api/v1"}/>
        {children}
      </body>
    </html>
  );
}

