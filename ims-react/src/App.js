import React from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import { ProtectedRoute, AdminRoute } from "./service/Guard";
import RegisterPage from "./pages/RegisterPage";
import LoginPage from "./pages/Login";
import SupplierPage from "./pages/SupplierPage";
import AddEditSupplierPage from "./pages/AddEditSupplierPage";
import CategoryPage from "./pages/CategoryPage";
import ProductPage from "./pages/ProductPage";
import AddEditProductPage from "./pages/AddEditProducts";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Navigate to="/register" />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/suppliers" element={<SupplierPage />} />
        <Route path="/add-supplier" element={<AddEditSupplierPage />} />
        <Route path="/edit-supplier/:supplierId" element={<AddEditSupplierPage />} />
        <Route path="/categories" element={<CategoryPage />} />
        <Route path="/products" element={
          <ProtectedRoute>
            <ProductPage />
          </ProtectedRoute>
        } />
        <Route path="/add-product" element={
          <AdminRoute>
            <AddEditProductPage />
          </AdminRoute>
        } />
        <Route path="/edit-product/:productId" element={
          <AdminRoute>
            <AddEditProductPage />
          </AdminRoute>
        } />
      </Routes>
    </Router>
  );
}

export default App;
