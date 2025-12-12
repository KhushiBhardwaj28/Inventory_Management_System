import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import ApiService from "../service/ApiService";
import AuthLayout from "../components/AuthLayout";

const LoginPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [message, setMessage] = useState("");

  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const res = await ApiService.loginUser({ email, password });
      const token = res?.data?.token;
      if (token) {
        localStorage.setItem("token", token);
        setMessage("");
        navigate("/");
      } else {
        setMessage("Login failed");
      }
    } catch (err) {
      setMessage(err?.response?.data?.message || "Login failed");
    }
  };

  return (
    <AuthLayout>
      <div className="page" style={{ padding: '48px 16px' }}>
        <section className="glass-panel ui-section" style={{ maxWidth: 480, margin:'40px auto' }} aria-labelledby="login-title">
          <header className="ui-section-header" style={{ justifyContent:'center' }}>
            <h2 id="login-title" className="ui-title">Welcome back</h2>
          </header>
          {message && <p className="ui-toast" role="status" style={{ textAlign:'center' }}>{message}</p>}
          <form onSubmit={handleLogin} className="ui-form" style={{ display:'grid', gap:12 }}>
            <div>
              <label htmlFor="email">Email</label>
              <input id="email" className="ui-input" type="email" placeholder="you@example.com" value={email} onChange={e => setEmail(e.target.value)} required />
            </div>
            <div>
              <label htmlFor="password">Password</label>
              <input id="password" className="ui-input" type="password" placeholder="••••••••" value={password} onChange={e => setPassword(e.target.value)} required />
            </div>
            <div className="ui-actions" style={{ justifyContent:'center' }}>
              <button type="submit" className="ui-btn ui-btn-primary">Log In</button>
            </div>
          </form>
          <div className="ui-actions" style={{ justifyContent:'center', marginTop: 8 }}>
            <button className="ui-btn" type="button" onClick={() => navigate('/register')}>Create account</button>
          </div>
        </section>
      </div>
    </AuthLayout>
  );
};

export default LoginPage;
