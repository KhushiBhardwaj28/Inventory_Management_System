import React from "react";
import { Link } from "react-router-dom";
import ApiService from "../service/ApiService";

const logout = () => {
  ApiService.logout();
};

const Sidebar = () => {
  const isAuth = ApiService.isAuthenticated();
  const isAdmin = ApiService.isAdmin();

  return (
    <div className="sidebar glass-card">
      <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
        <h1 className="heading-lg" style={{ margin: 0 }}>IMS</h1>
        <span className="muted" style={{ fontSize: 12 }}>v1</span>
      </div>
      <ul className="nav-links" style={{ listStyle: 'none', padding: 0, marginTop: 16, display: 'grid', gap: 8 }}>
        {isAuth && (
          <li className="glass-card" style={{ padding: 10 }}>
            <Link to="/dashboard" className="btn-ghost" style={{ display: 'block', width: '100%' }}>Dashboard</Link>
          </li>
        )}

        {isAuth && (
          <li className="glass-card" style={{ padding: 10 }}>
            <Link to="/transaction" className="btn-ghost" style={{ display: 'block', width: '100%' }}>Transactions</Link>
          </li>
        )}

        {isAdmin && (
          <li className="glass-card" style={{ padding: 10 }}>
            <Link to="/categories" className="btn-ghost" style={{ display: 'block', width: '100%' }}>Category</Link>
          </li>
        )}

        {isAdmin && (
          <li className="glass-card" style={{ padding: 10 }}>
            <Link to="/product" className="btn-ghost" style={{ display: 'block', width: '100%' }}>Product</Link>
          </li>
        )}

        {isAdmin && (
          <li className="glass-card" style={{ padding: 10 }}>
            <Link to="/suppliers" className="btn-ghost" style={{ display: 'block', width: '100%' }}>Supplier</Link>
          </li>
        )}

        {isAuth && (
          <li className="glass-card" style={{ padding: 10 }}>
            <Link to="/purchase" className="btn-ghost" style={{ display: 'block', width: '100%' }}>Purchase</Link>
          </li>
        )}

        {isAuth && (
          <li className="glass-card" style={{ padding: 10 }}>
            <Link to="/sell" className="btn-ghost" style={{ display: 'block', width: '100%' }}>Sell</Link>
          </li>
        )}

        {isAuth && (
          <li className="glass-card" style={{ padding: 10 }}>
            <Link to="/profile" className="btn-ghost" style={{ display: 'block', width: '100%' }}>Profile</Link>
          </li>
        )}

        {isAuth && (
          <li className="glass-card" style={{ padding: 10 }}>
            <Link onClick={logout} to="/login" className="btn-ghost" style={{ display: 'block', width: '100%' }}>
              Logout
            </Link>
          </li>
        )}
      </ul>
    </div>
  );
};

export default Sidebar;
