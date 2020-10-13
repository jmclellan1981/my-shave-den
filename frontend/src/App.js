import React from "react";
// import { Router } from "@reach/router";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import { Provider } from "react-redux";
import { createStore } from "redux";
import "./App.css";
import TopMenuBar from "./components/top-menu-bar/TopMenuBar";
import Home from "./components/home";
import LoginPanel from "./components/login-panel";
import RegisterPanel from "./components/register-panel";
import Wishlist from "./components/wishlist";
import rootReducer from "./reducers";

function App() {
  const store = createStore(rootReducer);
  return (
    <Provider store={store}>
      <div className="App">
        <>
          <Router>
            <TopMenuBar />
            <Switch>
              <Route exact path="/login">
                <LoginPanel />
              </Route>
              <Route exact path="/register">
                <RegisterPanel />
              </Route>
              <Route exact path="/wishlist">
                <Wishlist />
              </Route>
              <Route exact path="/">
                <Home />
              </Route>
            </Switch>
          </Router>
        </>
      </div>
    </Provider>
  );
}

export default App;
