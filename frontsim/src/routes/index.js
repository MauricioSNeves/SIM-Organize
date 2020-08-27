import React from 'react'
import { BrowserRouter, Switch } from 'react-router-dom'

import Home from '../pages/Institucional/Home'
import Startup from '../pages/Institucional/Startup'
import Register from '../pages/Institucional/Register'
import Login from '../pages/Institucional/Logon'

import Checklist from '../pages/Aplication/Checklist'
import QuatroDX from '../pages/Aplication/Initial/4dx'
import Initial from '../pages/Aplication/Initial'
import Calendar from '../pages/Aplication/Calendar'

import RouteWrapper from './Route';

export default function Routes() {
    return (
        <BrowserRouter>
            <Switch>
                <RouteWrapper path="/user/checklist" component={Checklist} isPrivate />
                <RouteWrapper path="/user/initial/4dX/:id" component={QuatroDX} isPrivate />
                <RouteWrapper path="/user/initial" component={Initial} isPrivate />
                <RouteWrapper path="/user/calendar" component={Calendar} isPrivate />
                {/* <RouteWrapper path=[*] component={Calendar} isPrivate /> */}

                <RouteWrapper path="/" exact component={Home} />
                <RouteWrapper path="/startup" component={Startup} />
                <RouteWrapper path="/login" component={Login} />
                <RouteWrapper path="/register" component={Register} />
            </Switch>
        </BrowserRouter>
    )
}