import React, { useState } from "react";
import { useDispatch } from "react-redux";
import ArrowDropDown from "@material-ui/icons/ArrowDropDown";
import FilterList from "@material-ui/icons/FilterList";
import "./wishlist-header.css";
import { UPDATE_WISHLIST_SORT } from "../../reducers";

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
  return (
    <div className="sort-by-panel">
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
export { sortOptions };
export default WishlistHeader;
