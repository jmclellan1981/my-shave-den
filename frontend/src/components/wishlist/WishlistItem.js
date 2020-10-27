import React from "react";
import { useDispatch, useSelector } from "react-redux";
import RemoveCircle from "@material-ui/icons/RemoveCircle";
import { REMOVE_WISHLIST_ITEM } from "../../reducers";
import { sendAuthenticatedRequest } from "../../helpers/ajaxHelpers";
import "./wishlist-item.css";

const WishlistItem = ({ item }) => {
  const dispatch = useDispatch();
  const token = useSelector(state => state.accessToken);
  const removeItem = itemId => {
    dispatch({ type: REMOVE_WISHLIST_ITEM, payload: itemId });
    const url = `/wishlist/item/${itemId}`;
    sendAuthenticatedRequest(url, token, "DELETE");
  };
  return (
    <div className="wishlist-item">
      {item.productModel.imageSource && (
        <a href={item.productModel.url}>
          <img src={item.productModel.imageSource} alt="product" />
        </a>
      )}
      <div className="product-info">
        <div>
          <a href={item.productModel.url}>
            <h3>{item.productModel.title}</h3>
          </a>
        </div>
      </div>
      <div title="Remove item" onClick={() => removeItem(item.id)}>
        <RemoveCircle style={{ color: "red" }} />
      </div>
    </div>
  );
};

export default WishlistItem;
