import { combineReducers } from "redux";
import { ACCESS_TOKEN } from "../components/login-panel";
const NEW_WISHLIST_ITEMS = "NEW_WISHLISTITEMS";
const ADD_WISHLIST_ITEM = "ADD_WISHLIST_ITEM";
const UPDATE_ACCESS_TOKEN = "UPDATE_ACCESS_TOKEN";
const UPDATE_WISHLIST_SORT = "UPDATE_WISHLIST_SORT";

const accessToken = (
  state = localStorage.getItem(ACCESS_TOKEN),
  { type, value }
) => {
  if (type === UPDATE_ACCESS_TOKEN) {
    return value;
  }
  return state;
};

const wishlistItems = (state = [], { type, payload }) => {
  if (type === NEW_WISHLIST_ITEMS) {
    return payload;
  }
  if (type === ADD_WISHLIST_ITEM) {
    return [...state, payload];
  }
  return state;
};

const wishlistSort = (state = null, { type, payload }) => {
  if (type === UPDATE_WISHLIST_SORT) {
    return payload;
  }
  return state;
};

export { NEW_WISHLIST_ITEMS, UPDATE_ACCESS_TOKEN, UPDATE_WISHLIST_SORT };

export default combineReducers({ accessToken, wishlistItems, wishlistSort });
