import { combineReducers } from "redux";
import { ACCESS_TOKEN } from "../components/login-panel";
const NEW_WISHLIST_ITEMS = "NEW_WISHLISTITEMS";
const ADD_WISHLIST_ITEM = "ADD_WISHLIST_ITEM";
const UPDATE_ACCESS_TOKEN = "UPDATE_ACCESS_TOKEN";
const UPDATE_WISHLIST_SORT = "UPDATE_WISHLIST_SORT";
const UPDATE_WISHLIST_FILTER = "UPDATE_WISHLIST_FILTER";
const REMOVE_WISHLIST_ITEM = "REMOVE_WISHLIST_ITEM";

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
    return payload || state;
  }
  if (type === ADD_WISHLIST_ITEM) {
    return [...state, payload];
  }
  if (type === REMOVE_WISHLIST_ITEM) {
    return state.filter(item => item.id !== payload);
  }
  return state;
};

const wishlistSort = (state = null, { type, payload }) => {
  if (type === UPDATE_WISHLIST_SORT) {
    return payload;
  }
  return state;
};

const wishlistFilter = (
  state = { sites: [], categories: [] },
  { type, payload }
) => {
  if (type === UPDATE_WISHLIST_FILTER) {
    const sites =
      payload.type !== "SITE"
        ? state.sites
        : payload.isSelected
        ? [...state.sites, payload.option.option]
        : state.sites.filter((site) => site !== payload.option);
    const categories =
      payload.type !== "CATEGORY"
        ? state.categories
        : payload.isSelected
        ? [...state.categories, payload.option]
        : state.categories.filter((site) => site !== payload.option);
    return { sites, categories };
  }
  return state;
};

export {
  NEW_WISHLIST_ITEMS,
  UPDATE_ACCESS_TOKEN,
  UPDATE_WISHLIST_SORT,
  UPDATE_WISHLIST_FILTER,
  REMOVE_WISHLIST_ITEM
};

export default combineReducers({
  accessToken,
  wishlistItems,
  wishlistSort,
  wishlistFilter,
});
