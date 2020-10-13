import React, { useState } from "react";
import { useSelector } from "react-redux";
import LoginPanel, { ACCESS_TOKEN } from "../login-panel";
import Wishlist from "../wishlist";
import "./home.css";

const Home = () => {
  const accessToken = useSelector(state => state.accessToken);
  console.log(`rendering home with accessToken=${accessToken}`);
  // const accessToken = localStorage.getItem(ACCESS_TOKEN);
  const content = accessToken ? <Wishlist /> : <LoginPanel />;
  // return <div className="home">{content}</div>;
  return content;
};
export default Home;
