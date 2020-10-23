import React from "react";
import { Link, useHistory } from "react-router-dom";
import { useDispatch } from "react-redux";
import "./login-panel.css";

const ACCESS_TOKEN = "myShaveDenAccessToken";

const LoginPanel = () => {
  const dispatch = useDispatch();
  const history = useHistory();

  const saveTokenAndAlertExtension = data => {
    localStorage.setItem(ACCESS_TOKEN, data.accessToken);
    const loginEvent = new CustomEvent("MY_SHAVE_DEN_LOGIN", {
      detail: {
        myShaveDenAccessToken: data.accessToken
      }
    });
    window.dispatchEvent(loginEvent);

    dispatch({ type: "UPDATE_ACCESS_TOKEN", value: data.accessToken });
    history.push("/");
  };

  const submitLogin = async () => {
    const url = "api/auth/login";
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const data = { username, password };

    const response = await fetch(url, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      mode: "cors",
      cache: "no-cache",
      credentials: "same-origin",
      redirect: "follow",
      referrerPolicy: "no-referrer",
      body: JSON.stringify(data)
    });
    const responseData = await response.json();
    saveTokenAndAlertExtension(responseData);
  };
  return (
    <div className="login-container">
      <div className="login-panel">
        <h3>Log In</h3>

        <div className="input-row">
          <label>Username</label>
          <input id="username" type="text" />
        </div>
        <div className="input-row">
          <label>Password</label>
          <input id="password" type="password" />
        </div>

        <div className="button-row">
          <button type="button" onClick={() => submitLogin()}>
            Log In
          </button>
        </div>
        <div className="register-link">
          <Link to="/register">Sign up here.</Link>
        </div>
      </div>
    </div>
  );
};
export { ACCESS_TOKEN };
export default LoginPanel;
