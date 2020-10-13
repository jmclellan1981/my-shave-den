import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { sendAuthenticatedRequest } from "../../helpers/ajaxHelpers";
import WishlistItem from "./WishlistItem";
import "./wishlist.css";

const Wishlist = ({ userId }) => {
  const accessToken = useSelector(state => state.accessToken);
  const [wishlistItems, setWishlistItems] = useState([]);
  useEffect(() => {
    const requestWishlist = async () => {
      const url = "/wishlist";
      const response = await sendAuthenticatedRequest(url, accessToken);
      const wishlist = await response.json();
      setWishlistItems(wishlist.wishlistItems);
    };
    if (accessToken) {
      requestWishlist();
    } else {
      setWishlistItems([]);
    }
  }, [accessToken]);
  const wishlistItemsDisplay = wishlistItems.map(wishlistItem => (
    <WishlistItem item={wishlistItem} />
  ));
  return <div className="wishlist">{wishlistItemsDisplay}</div>;
};

export default Wishlist;
