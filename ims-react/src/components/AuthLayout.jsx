import React from "react";
import { useNavigate } from "react-router-dom";

const AuthLayout = ({ children }) => {
  const navigate = useNavigate();
  return (
    <div className="app" style={{ minHeight: "100vh", display: "flex", flexDirection: "column" }}>
      <header className="glass-panel" style={{ padding: "12px 16px", display: "flex", alignItems: "center", justifyContent: "space-between" }}>
        <div style={{ display: "flex", alignItems: "center", gap: 8 }}>
          <span aria-hidden style={{ width: 10, height: 10, borderRadius: 999, background: "#4f46e5", display: "inline-block" }} />
          <strong>Inventory Management</strong>
        </div>
        <nav style={{ display: "flex", gap: 8 }}>
          <button className="ui-btn" onClick={() => navigate("/login")}>Login</button>
          <button className="ui-btn" onClick={() => navigate("/register")}>Register</button>
          <button className="ui-btn" onClick={() => navigate("/")}>Dashboard</button>
        </nav>
      </header>
      <main style={{ flex: 1 }}>{children}</main>
      <footer style={{ padding: "16px", textAlign: "center", color: "#6b7280" }}>© {new Date().getFullYear()} Inventory Management</footer>
    </div>
  );
};

export default AuthLayout;
