import React, { useState } from "react";
import "./register-panel.css";

const ajaxParams = {
  method: "POST",
  headers: {
    "Content-Type": "application/json"
  },
  mode: "cors",
  cache: "no-cache",
  credentials: "same-origin",
  redirect: "follow",
  referrerPolicy: "no-referrer"
};

const RegisterPanel = () => {
  const [passwordValid, setPasswordValid] = useState(false);
  const [usernameValid, setUsernameValid] = useState(true);
  const [emailValid, setEmailValid] = useState(true);
  const passwordStyle = passwordValid ? "valid" : "invalid";

  const validatePassword = () => {
    const passwordValue = document.getElementById("password").value;
    const passwordConfirm = document.getElementById("confirm-password").value;
    setPasswordValid(passwordValue === passwordConfirm);
  };

  const validateUsername = async () => {
    const username = document.getElementById("username").value;
    const validateUrl = `api/auth/validate/username/${username}`;
    const response = await fetch(validateUrl);
    const isValid = await response.json();
    setUsernameValid(isValid);
  };

  const validateEmail = async () => {
    const email = document.getElementById("email").value;
    const validateUrl = `api/auth/validate/email/${email}`;
    const response = await fetch(validateUrl);
    const isValid = await response.json();
    setEmailValid(isValid);
  };

  const register = () => {
    const url = "api/auth/register";
    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const data = { username, password, email };
    const params = { ...ajaxParams, body: JSON.stringify(data) };
    fetch(url, params);
  };
  return (
    <div className="register-container">
      <div className="register-panel">
        <h3>Sign Up</h3>

        <div className="input-row">
          <label>Username</label>
          <input id="username" type="text" onBlur={() => validateUsername()} />
        </div>
        {usernameValid || <div>Username taken</div>}
        <div className="input-row">
          <label>Email</label>
          <input type="text" id="email" onBlur={() => validateEmail()} />
        </div>
        {emailValid || <div>Email address taken</div>}
        <div className="input-row">
          <label>Password</label>
          <input id="password" type="password" />
        </div>
        <div className="input-row">
          <label>Confirm Password</label>
          <input
            id="confirm-password"
            type="password"
            className={passwordStyle}
            onChange={() => validatePassword()}
          />
        </div>

        <div className="button-row">
          <button
            type="button"
            disabled={!passwordValid}
            onClick={() => register()}
          >
            Sign Up
          </button>
        </div>
      </div>
    </div>
  );
};

export default RegisterPanel;
