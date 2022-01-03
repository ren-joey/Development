import React from 'react';

import './Component.css';

export default class Component extends React.Component{
  constructor (props){
    super(props);
    // 該範例 Main.jsx 傳下來兩個 props
    // 1. 用來顯示倒數數字的 count -> this.state.count (in Main.jsx 0:36)
    // 2. 用來 reset counter 的 function onReset -> this.handleReset (in Main.jsx 0:36)
  }

  render(){
    return(
      <div className="component">
        <h2>Countdown: {this.props.count}</h2>
        <button className="btn btn-primary btn-sm" onClick={this.props.onReset}>Reset</button>
      </div>
    );
  }
}
