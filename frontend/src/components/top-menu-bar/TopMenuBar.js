import React, { useState, useEffect } from "react";
import { useSelector } from "react-redux";
import { Link } from "react-router-dom";
import AccountCircle from "@material-ui/icons/AccountCircle";
import Notifications from "@material-ui/icons/Notifications";
import SiteSearch from "../site-search";
import ProfileQuickView from "../profile-quick-view";
import "./menu-bar.css";

const padding = { "padding-left": "5px", "padding-right": "5px" };

const TopMenuBar = () => {
  const [menuItems, setMenuItems] = useState([]);
  const [profileQuickViewVisible, setProfileQuickViewVisible] = useState(false);
  const accessToken = useSelector(state => state.accessToken);

  useEffect(() => {
    const fetchMenuItems = async () => {
      const url = "menu-items";
      const headers = new Headers({
        "Content-Type": "application/json"
      });
      headers.append("Authorization", "Bearer " + accessToken);
      const response = await fetch(url, { headers });
      const menuItemResponse = await response.json();
      setMenuItems(menuItemResponse);
    };
    if (accessToken) {
      fetchMenuItems();
    }
  }, [accessToken]);
  const menus = menuItems.map(menuItem => {
    if (menuItem.action) {
      return <div className="menu-item">{menuItem.title}</div>;
    } else if (menuItem.path) {
      return <Link to={menuItem.path}>{menuItem.title}</Link>;
    } else {
      return null;
    }
  });
  return (
    <div className="top-menu-bar">
      <Link to="/">
        <button>
          <h3>My Shave Den</h3>
        </button>
      </Link>
      {accessToken && (
        <>
          {menus}
          <SiteSearch style={{ ...padding, "margin-left": "auto" }} />
          <Notifications style={padding} />
          <AccountCircle
            style={{ ...padding, cursor: "pointer" }}
            onClick={() =>
              setProfileQuickViewVisible(currentValue => !currentValue)
            }
          />
          {profileQuickViewVisible && (
            <ProfileQuickView
              setProfileQuickViewVisible={setProfileQuickViewVisible}
            />
          )}
        </>
      )}
    </div>
  );
};

export default TopMenuBar;
