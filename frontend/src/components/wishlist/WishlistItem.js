import React from "react";
import "./wishlist-item.css";

const WishlistItem = ({ item }) => (
  <div className="wishlist-item">
    {item.product.imageSource && (
      <a href={item.product.url}>
        <img src={item.product.imageSource} alt="product" />
      </a>
    )}
    <div className="product-info">
      <div>
        <a href={item.product.url}>
          <h3>{item.product.title}</h3>
        </a>
      </div>
      <p>{item.product.description}</p>
    </div>
  </div>
);

export default WishlistItem;
