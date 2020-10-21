import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { sendAuthenticatedRequest } from "../../helpers/ajaxHelpers";
import WishlistItem from "./WishlistItem";
import WishlistHeader from "./WishlistHeader";
import { NEW_WISHLIST_ITEMS } from "../../reducers";
import "./wishlist.css";

const Wishlist = ({ userId }) => {
  const accessToken = useSelector(state => state.accessToken);
  const wishlistItems = useSelector(state => state.wishlistItems);
  const wishlistSort = useSelector(state => state.wishlistSort);
  const dispatch = useDispatch();

  useEffect(() => {
    const requestWishlist = async () => {
      const url = "/wishlist";
      const response = await sendAuthenticatedRequest(url, accessToken);
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

  const wishlistItemsDisplay = wishlistItems.map(wishlistItem => (
    <WishlistItem item={wishlistItem} />
  ));
  return (
    <div className="wishlist">
      <WishlistHeader />
      {wishlistItemsDisplay}
    </div>
  );
};

export default Wishlist;
