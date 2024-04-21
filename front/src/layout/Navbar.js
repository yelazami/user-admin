import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <div>

<nav className="navbar navbar-expand-lg navbar-light navbar-dark bg-primary">
  <a className="navbar-brand" href="#">Full Stack APP</a>
  <Link className='btn btn-outline-light' to='/adduser'>Add User</Link>

</nav>

    </div>
  )
}
