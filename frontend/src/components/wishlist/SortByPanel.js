import React, { useRef } from "react";
import { useDispatch } from "react-redux";
import { UPDATE_WISHLIST_SORT } from "../../reducers";
import { useOutsideClick } from "../../hooks/useOutsideClick";
import { sortOptions } from "./WishlistHeader";

export const SortByPanel = ({ closeMenu, menuRef }) => {
  const dispatch = useDispatch();
  const ref = useRef(null);
  useOutsideClick(ref, closeMenu);
  const style = {
    top: menuRef.current.offsetTop + menuRef.current.offsetHeight,
    left: menuRef.current.offsetLeft
  };
  return (
    <div className="sort-by-panel" ref={ref} style={style}>
      <div
        className="header-menu-option"
        onClick={() => {
          dispatch({
            type: UPDATE_WISHLIST_SORT,
            payload: sortOptions.dateCreated
          });
          closeMenu();
        }}
      >
        Date Added
      </div>
      <div className="header-menu-option">Site</div>
      <div className="header-menu-option">Ranked Order</div>
      <div
        className="header-menu-option"
        onClick={() => {
          dispatch({
            type: UPDATE_WISHLIST_SORT,
            payload: sortOptions.productType
          });
          closeMenu();
        }}
      >
        Category
      </div>
      <div
        className="header-menu-option"
        onClick={() => {
          dispatch({
            type: UPDATE_WISHLIST_SORT,
            payload: sortOptions.title
          });
          closeMenu();
        }}
      >
        Title
      </div>
    </div>
  );
};
