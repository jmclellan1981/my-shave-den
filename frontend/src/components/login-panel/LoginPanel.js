import React from "react";
import { Link, useHistory } from "react-router-dom";
import { useDispatch } from "react-redux";
import { sendAuthenticatedRequest } from "../../helpers/ajaxHelpers";
import "./login-panel.css";

const ACCESS_TOKEN = "accessToken";

const LoginPanel = () => {
  const dispatch = useDispatch();
  const history = useHistory();
  const testEndpoint = token => {
    const url = "/wishlist/item";
    const body = {
      description: "Test wishlist item",
      productId: "testId",
      url: "www.test.com",
      site: "MAGGARDS"
    };
    sendAuthenticatedRequest(url, token, "POST", body);
  };

  const saveTokenAndAlertExtension = data => {
    localStorage.setItem(ACCESS_TOKEN, data.accessToken);
    const loginEvent = new CustomEvent("MY_SHAVE_DEN_LOGIN", {
      detail: {
        accessToken: data.accessToken
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
    //const email = document.getElementById("email").value;
    const data = { username, password };

    const response = await fetch(url, {
      method: "POST", // or 'PUT'
      headers: {
        "Content-Type": "application/json"
      },
      mode: "cors", // no-cors, *cors, same-origin
      cache: "no-cache", // *default, no-cache, reload, force-cache, only-if-cached
      credentials: "same-origin", // include, *same-origin, omit
      redirect: "follow", // manual, *follow, error
      referrerPolicy: "no-referrer", // no-referrer, *no-referrer-when-downgrade, origin, origin-when-cross-origin, same-origin, strict-origin, strict-origin-when-cross-origin, unsafe-url
      body: JSON.stringify(data)
    });
    const responseData = await response.json();
    saveTokenAndAlertExtension(responseData);

    //clearValues();
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
