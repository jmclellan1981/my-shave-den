import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { useHistory } from "react-router-dom";
import { sendAuthenticatedRequest } from "../../helpers/ajaxHelpers";
import WishlistItem from "./WishlistItem";
import WishlistHeader from "./WishlistHeader";
import { NEW_WISHLIST_ITEMS } from "../../reducers";
import { ACCESS_TOKEN } from "../login-panel";
import "./wishlist.css";

const Wishlist = ({ userId }) => {
  const history = useHistory();
  const accessToken = useSelector(state => state.accessToken);
  const wishlistItems = useSelector(state => state.wishlistItems);
  const wishlistSort = useSelector(state => state.wishlistSort);
  const filters = useSelector(state => state.wishlistFilter);
  const dispatch = useDispatch();

  useEffect(() => {
    const requestWishlist = async () => {
      const url = "/wishlist";
      const response = await sendAuthenticatedRequest(url, accessToken);
      if (response.status === 401) {
        localStorage.removeItem(ACCESS_TOKEN);
        dispatch({ type: "UPDATE_ACCESS_TOKEN", value: null });
        history.push("/login");
      }
      const wishlist = await response.json();
      dispatch({ type: NEW_WISHLIST_ITEMS, payload: wishlist.wishlistItems });
    };
    if (accessToken) {
      requestWishlist();
    } else {
      dispatch({ type: NEW_WISHLIST_ITEMS, payload: [] });
    }
  }, [accessToken, dispatch]);

  if (wishlistSort) {
    let sortItem1 = "";
    let sortItem2 = "";
    wishlistItems.sort((item1, item2) => {
      if (item1[wishlistSort] && item2[wishlistSort]) {
        sortItem1 = item1[wishlistSort];
        sortItem2 = item2[wishlistSort];
      } else if (
        item1.productModel[wishlistSort] &&
        item2.productModel[wishlistSort]
      ) {
        sortItem1 = item1.productModel[wishlistSort];
        sortItem2 = item2.productModel[wishlistSort];
      }
      if (sortItem1 < sortItem2) {
        return -1;
      } else if (sortItem1 > sortItem2) {
        return 1;
      } else {
        return 0;
      }
    });
  }
  let displayedItems = [...wishlistItems];
  if (filters.sites.length > 0) {
    displayedItems = displayedItems.filter(item =>
      filters.sites.includes(item.productModel.site)
    );
  }

  if (filters.categories.length > 0) {
    displayedItems = displayedItems.filter(item =>
      filters.categories.includes(item.productModel.productType)
    );
  }
  const wishlistItemsDisplay = displayedItems.map(wishlistItem => (
    <WishlistItem item={wishlistItem} key={wishlistItem.id} />
  ));
  return (
    <div className="wishlist">
      <WishlistHeader />
      {wishlistItemsDisplay}
    </div>
  );
};

export default Wishlist;
