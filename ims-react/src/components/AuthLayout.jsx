import React from "react";

export default function AuthLayout({ children }) {
  return (
    <div className="app auth" style={{ minHeight: '100vh', display: 'flex', flexDirection: 'column' }}>
      <main style={{ flex: 1 }}>
        {children}
      </main>
    </div>
  );
}
