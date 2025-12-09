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
import SellPage from "./pages/SellPage";
import PurchasePage from "./pages/PurchasePage";
import TransactionsPage from "./pages/TransactionsPage";
import TransactionDetailsPage from "./pages/TransactionDetailsPage";
import ProfilePage from "./pages/ProfilePage";
import DashboardPage from "./pages/DashboardPage";

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
        <Route path="/product" element={<AdminRoute element={<ProductPage/>}/>}/>
        <Route path="/add-product" element={<AdminRoute element={<AddEditProductPage/>}/>}/>
        <Route path="/edit-product/:productId" element={<AdminRoute element={<AddEditProductPage/>}/>}/>

        <Route path="/purchase" element={<ProtectedRoute element={<PurchasePage/>}/>}/>
        <Route path="/sell" element={<ProtectedRoute element={<SellPage/>}/>}/>
        <Route path="/transaction" element={<ProtectedRoute element={<TransactionsPage/>}/>}/>
        <Route path="/transaction/:transactionId" element={<ProtectedRoute element={<TransactionDetailsPage/>}/>}/>
        
        <Route path="/profile" element={<ProtectedRoute element={<ProfilePage/>}/>}/>
        <Route path="/dashboard" element={<ProtectedRoute element={<DashboardPage/>}/>}/>



        <Route path="*" element={<LoginPage/>}/>



      </Routes>
    </Router>
  );
}

export default App;
