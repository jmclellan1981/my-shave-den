import React from "react";
import { useSelector } from "react-redux";
import LoginPanel from "../login-panel";
import Wishlist from "../wishlist";
import "./home.css";

const Home = () => {
  const accessToken = useSelector(state => state.accessToken);
  const content = accessToken ? <Wishlist /> : <LoginPanel />;
  return content;
};
export default Home;
