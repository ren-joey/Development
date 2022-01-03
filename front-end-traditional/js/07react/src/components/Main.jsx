import Component from './Component.jsx';
import React from 'react';

import './Main.css';

export default class Main extends React.Component {
  static staticProps = {
    countdownNum: 5
  }
  // 設定一個 class 的 static prop，這個數值是不容許被改變的

  // static props = x 這種定義方法屬於 ES7 的範疇，
  // 因此如果要使用該方法需將 babel-plugin-transform-class-properties 安裝好
  // 並在 webpack.config.js 中設定完成

  constructor(props){
    super(props);

    this.state = {
      count: Main.staticProps.countdownNum
      // 將 this.state.count 的值設定成 staticProps的值
    };
    this.countdownId = null;
    // 先把 this.countdownId 名稱建立起來，並令他為空集合

    this.handleReset = this.handleReset.bind(this);
    // Main.jsx 以及 Components.jsx 在交互呼叫function的時候會一直需要用到this
    // 但 Components.jsx 在呼叫回 Main.jsx 的時候，this的對象會變成 window
    // 因此會用 this.handleReset = this.handleReset.bind(this) 來綁定 this 一定是 Main Class
  }

  render(){
    return (
      <div className="main">
        <h1>Hello React</h1>
        <Component count={this.state.count} onReset={this.handleReset} />
      </div>
    );
  }
  // 把 this.state.count 與 this.handleReset function 傳下去給 Component.jsx

  tick(){
    if (this.state.count > 0){
      this.setState((prevState, props) => ({
        // 因為setState是非同步更新(asynchronous)，
        // 為了避免後續setState運算的時候數值被其他程式改變，
        // 因此使用這邊使用prevState特殊function把當下setState的數值另外儲存成obj，
        // 之後react在跑setState的時候就能確定數值是該程式碼運算時當下的數值
        count: prevState.count - 1
      }));
    }else{
      clearInterval(this.countdownId);
      // 如果 this.state.count <= 0 就停止倒數
    }
  }

  componentDidMount(){
    this.countdownId = setInterval(() => this.tick(), 1000);
    // 在 renderDOM 完成工作之後就執行倒數 function tick()
  }

  componentWillUnmount(){
    clearInterval(this.countdownId);
  }

  handleReset(){
    // 用來傳給 Component.jsx 的 function
    // 讓 Component 可以在特定事件發生的時候 call
    // 該範例 Component.jsx 是在 onClick 的時候 fire function
    clearInterval(this.countdownId);
    this.setState({
      count: Main.staticProps.countdownNum
    }, () => {
      this.countdownId = setInterval(() => this.tick(), 1000);
    });
    this.setState({..: ..}, () => {});
    // 這種寫法可以確保後面的 arrow function 執行的時候，前面的setState已經執行完畢了
    // 因為 setState 是非同步 asynchronous ，
    // 所以後面的 function 如果必須在意前面 setState 做的事情，
    // 就必須採用這個方法
  }
}
