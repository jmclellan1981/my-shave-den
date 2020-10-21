import React, { useState, useRef } from "react";
import { useDispatch } from "react-redux";
import ArrowDropDown from "@material-ui/icons/ArrowDropDown";
import FilterList from "@material-ui/icons/FilterList";
import "./wishlist-header.css";
import { UPDATE_WISHLIST_SORT } from "../../reducers";
import { useOutsideClick } from "../../hooks/useOutsideClick";

const sortOptions = {
  title: "title",
  dateCreated: "dateCreated",
  dateModified: "dateModified",
  productType: "productType"
};
const WishlistHeader = () => {
  const [sortByVisible, setSortByVisible] = useState(false);

  return (
    <div className="wishlist-header">
      <div
        className={`wishlist-header-menu ${sortByVisible ? "selected" : ""}`}
        onClick={() => setSortByVisible(isVisible => !isVisible)}
      >
        Sort By:
        <ArrowDropDown />
      </div>
      {sortByVisible && (
        <SortByPanel closeMenu={() => setSortByVisible(false)} />
      )}
      <div className="wishlist-header-menu">
        <FilterList />
        Filters:
        <ArrowDropDown />
      </div>
    </div>
  );
};

const SortByPanel = ({ closeMenu }) => {
  const dispatch = useDispatch();
  const ref = useRef(null);
  useOutsideClick(ref, closeMenu);
  return (
    <div className="sort-by-panel" ref={ref}>
      <div
        className="header-menu-option"
        onClick={() => {
          console.log("dispatching action: " + sortOptions.dateCreated);
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
          console.log("dispatching action: " + sortOptions.productType);
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
          console.log("dispatching action: " + sortOptions.title);
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
export { sortOptions };
export default WishlistHeader;
