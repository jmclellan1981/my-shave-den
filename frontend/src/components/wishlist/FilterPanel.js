import React, { useRef, useEffect, useState } from "react";
import { FilterOption } from "./FilterOption";
import { useSelector } from "react-redux";
import { useOutsideClick } from "../../hooks/useOutsideClick";
import { sendAuthenticatedRequest } from "../../helpers/ajaxHelpers";

export const FilterPanel = ({ closeMenu, menuRef }) => {
  const accessToken = useSelector(state => state.accessToken);
  const [sites, setSites] = useState([]);
  const [categories, setCategories] = useState([]);
  const ref = useRef(null);
  useOutsideClick(ref, closeMenu);
  const filters = useSelector(state => state.wishlistFilter);
  useEffect(() => {
    const fetchSites = async () => {
      const url = "lookukps/data/WEBSITE";
      const response = await sendAuthenticatedRequest(url, accessToken);
      const sitesResponse = await response.json();
      setSites(sitesResponse);
    };
    const fetchCategories = async () => {
      const url = "lookups/data/ITEM_TYPE";
      const response = await sendAuthenticatedRequest(url, accessToken);
      const categoriesResponse = await response.json();
      setCategories(categoriesResponse);
    };
    if (accessToken) {
      fetchSites();
      fetchCategories();
    } else {
      setSites([]);
      setCategories([]);
    }
  }, [accessToken]);

  const style = {
    top: menuRef.current.offsetTop + menuRef.current.offsetHeight,
    left: menuRef.current.offsetLeft
  };
  return (
    <div className="filter-panel" ref={ref} style={style}>
      <div>Show Only:</div>
      <div>Sites:</div>
      <div>
        {sites.map(site => (
          <FilterOption
            data={{
              type: "SITE",
              name: site.dataName,
              description: site.dataDescription
            }}
            filters={filters}
            key={`SITE-${site.dataName}`}
          />
        ))}
      </div>
      <br></br>
      <div>Product Categories</div>
      {categories.map(category => (
        <FilterOption
          data={{
            type: "CATEGORY",
            name: category.dataName,
            description: category.dataDescription
          }}
          filters={filters}
          key={`CATEGORY-${category.dataName}`}
        />
      ))}
    </div>
  );
};
