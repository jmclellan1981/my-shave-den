import React from "react";
import "./wishlist-item.css";

const WishlistItem = ({ item }) => (
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
  </div>
);

export default WishlistItem;
