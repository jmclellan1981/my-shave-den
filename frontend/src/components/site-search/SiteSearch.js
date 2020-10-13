import React from "react";
import Search from "@material-ui/icons/Search";
import "./site-search.css";

const SiteSearch = ({ style }) => (
  <div className="site-search" style={style}>
    <input type="text" />
    <Search color="action" />
  </div>
);

export default SiteSearch;
