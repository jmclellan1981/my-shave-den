import React, { useState, useRef } from "react";
import ArrowDropDown from "@material-ui/icons/ArrowDropDown";
import FilterList from "@material-ui/icons/FilterList";
import "./wishlist-header.css";
import { FilterPanel } from "./FilterPanel";
import { SortByPanel } from "./SortByPanel";

export const sortOptions = {
  title: "title",
  dateCreated: "dateCreated",
  dateModified: "dateModified",
  productType: "productType"
};
const WishlistHeader = () => {
  const [sortByVisible, setSortByVisible] = useState(false);
  const [filterVisible, setFilterVisible] = useState(false);
  const sortMenuRef = useRef(null);
  const filterMenuRef = useRef(null);
  return (
    <div className="wishlist-header">
      <div
        className={`wishlist-header-menu ${sortByVisible ? "selected" : ""}`}
        onClick={() => setSortByVisible(isVisible => !isVisible)}
        ref={sortMenuRef}
      >
        Sort By:
        <ArrowDropDown />
      </div>
      {sortByVisible && (
        <SortByPanel
          closeMenu={() => setSortByVisible(false)}
          menuRef={sortMenuRef}
        />
      )}
      <div
        className={`wishlist-header-menu ${filterVisible ? "selected" : ""}`}
        onClick={() => setFilterVisible(isVisible => !isVisible)}
        ref={filterMenuRef}
      >
        <FilterList />
        Filters:
        <ArrowDropDown />
      </div>
      {filterVisible && (
        <FilterPanel
          closeMenu={() => setFilterVisible(false)}
          menuRef={filterMenuRef}
        />
      )}
    </div>
  );
};

export default WishlistHeader;
