import React from "react";
import Sidebar from "./SideBar";
import FloatingLines from "./FloatingLines";

const Layout = ({ children }) => {
    return (
        <div className="app-shell fade-in" style={{ position: 'relative' }}>
            <FloatingLines
                enabledWaves={['top', 'middle', 'bottom']}
                lineCount={[10, 15, 20]}
                lineDistance={[8, 6, 4]}
                bendRadius={5.0}
                bendStrength={-0.5}
                interactive={true}
                parallax={true}
                linesGradient={["#0ea5b7", "#3b82f6", "#7c3aed"]}
                mixBlendMode={'screen'}
            />
            <header className="app-header">
                <div className="heading-lg">Inventory Management</div>
                <div style={{ display: "flex", gap: 12 }}>
                    <button className="btn-ghost">Profile</button>
                    <button className="btn-primary">New Item</button>
                </div>
            </header>
            <aside className="app-sidebar float-in">
                <Sidebar />
            </aside>
            <main className="app-content float-in">
                {children}
            </main>
        </div>
    );
};

export default Layout;