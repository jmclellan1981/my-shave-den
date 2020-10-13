import React from "react";
import RegisterPanel from "../register-panel";
import LoginPanel from "../login-panel";

const MainContent = () => (
  <div className="main-content">
    <RegisterPanel path="/register" />
    <LoginPanel path="/login" />
  </div>
);

export default MainContent;
