import React from "react";
import { useDispatch } from "react-redux";
import "./profile-quick-view.css";
import { ACCESS_TOKEN } from "../login-panel";

const ProfileQuickView = ({ setProfileQuickViewVisible }) => {
  const dispatch = useDispatch();
  const logout = () => {
    localStorage.removeItem(ACCESS_TOKEN);
    setProfileQuickViewVisible(false);
    dispatch({ type: "UPDATE_ACCESS_TOKEN", value: null });
  };
  return (
    <div className="profile-quick-view">
      <div className="profile-menu-item">View Profile</div>
      <div className="profile-menu-item">Manage Account</div>
      <div className="profile-menu-item" onClick={() => logout()}>
        Logout
      </div>
    </div>
  );
};

export default ProfileQuickView;
