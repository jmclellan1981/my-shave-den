import { combineReducers } from "redux";
import { ACCESS_TOKEN } from "../components/login-panel";

const accessToken = (
  state = localStorage.getItem(ACCESS_TOKEN),
  { type, value }
) => {
  if (type === "UPDATE_ACCESS_TOKEN") {
    return value;
  }
  return state;
};

export default combineReducers({ accessToken });
