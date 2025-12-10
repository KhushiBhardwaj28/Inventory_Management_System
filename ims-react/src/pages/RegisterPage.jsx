import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import ApiService from "../service/ApiService";
import AuthLayout from "../components/AuthLayout";

const RegisterPage = () => {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");
  const [message, setMessage] = useState("");

  const navigate = useNavigate();

  const handleRegister = async (e) => {
    e.preventDefault();
    try {
      const registerData = { name, email, password, phoneNumber };
      await ApiService.registerUser(registerData);
      setMessage("Registration Successfull");
      navigate("/login");
    } catch (error) {
      showMessage(
        error.response?.data?.message || "Error Registering a User: " + error
      );
      console.log(error);
    }
  };

  const showMessage = (msg) => {
    setMessage(msg);
    setTimeout(() => {
      setMessage("");
    }, 4000);
  };

  return (
    <AuthLayout>
      <div className="page" style={{ padding: '48px 16px' }}>
        <section className="glass-panel ui-section" style={{ maxWidth: 480, margin:'40px auto' }} aria-labelledby="register-title">
          <header className="ui-section-header" style={{ justifyContent:'center' }}>
            <h2 id="register-title" className="ui-title">Create an account</h2>
          </header>
          {message && <p className="ui-toast" role="status" style={{ textAlign:'center' }}>{message}</p>}
          <form onSubmit={handleRegister} className="ui-form" style={{ display:'grid', gap:12 }}>
            <div>
              <label htmlFor="name">Name</label>
              <input id="name" className="ui-input" type="text" placeholder="Your name" value={name} onChange={e => setName(e.target.value)} required />
            </div>
            <div>
              <label htmlFor="email">Email</label>
              <input id="email" className="ui-input" type="email" placeholder="you@example.com" value={email} onChange={e => setEmail(e.target.value)} required />
            </div>
            <div>
              <label htmlFor="password">Password</label>
              <input id="password" className="ui-input" type="password" placeholder="••••••••" value={password} onChange={e => setPassword(e.target.value)} required />
            </div>
            <div className="ui-actions" style={{ justifyContent:'center' }}>
              <button type="submit" className="ui-btn ui-btn-primary">Create Account</button>
            </div>
          </form>
        </section>
      </div>
    </AuthLayout>
  );
};

export default RegisterPage;
