import React from 'react';
import ReactDOM from 'react-dom';
// import $ from 'jquery';

// GLOBAL variable
var G_val = 1;
var G_list = [{
  id: 1,
  text: '001'
},{
  id: 2,
  text: '002'
}];

// CSS Style1
var style = {
  color: 'red',
  fontWeight: 900
}

// const props
var props = {
  val: 10
}

window.onload = function(){
  var name = 'Bob';
  var url = 'https://www.facebook.com';
  // 如果要render的ReactDOM超過一行，建議用()框起來
  // 要背render的html第一層只能有一個DOM
  ReactDOM.render (
    (<div>
      <h1>Hello {name}!</h1>
      <a className="numberSrc" href={url}>Number {1+1}</a>
    </div>)
    ,
    document.getElementById('root')
  );

  setInterval(tick, 1000);

  ReactDOM.render (
    (<div>
      <ComponentTest name="Bob" />
      <ComponentTest name="Andy" />
      <Counter val="3" />
      <FormControlledElement inputValue="testValue"/>
      <FormUncontrolledElement />
      <IfExpression val={G_val} />
      {/* 如果想要在 react 的程式碼中執行 js 就必須用 {} 大括號框起來 */}
      <IfElseExpression {...props} />
      {/* 可以使用 Spread 將 props 先定義好，直接call進來 */}
      <LoopExpression isClass />
      {/* 預設沒有給值的 props 會給 true ， isClass={true}*/}
    </div>),
    document.getElementById('components')
  )
}

function tick(){
  const date = new Date().toLocaleTimeString();
  const elDate = <p>{date}</p>;
  ReactDOM.render(elDate, document.getElementById('time'));
}

class ComponentTest extends React.Component {
  constructor(props){
    super(props);
  }
  render(){
    return <p>My name is {this.props.name}</p>;
  }
}

// 此寫法與上方的寫法作用相同
// function Component(props){
//   return <p>My name is {props.name}</p>;
// }

class Counter extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      count: this.props.val
    };
    // props絕對不能直接用 = 來更改，react不會重新render
    // 更改props的數值只能用setState來更新
  }

  render(){
    return <p>Countdown: {this.state.count}</p>;
  }

  //lifecycle methods
  //componentDidMount 意指在render產生DOM完成之後會跑一次的function
  componentDidMount(){
    this.countdownId = setInterval(() => {
      this.setState({
        count: this.state.count -1
      });
      if(this.state.count == 0){
        this.setState({
          count: 'TimesUp!'
        });
        clearInterval(this.countdownId);
      }
    }, 1000);
  }

  //componentWillUnmount 意指在render刪除DOM的時候會跑一次的function
  componentWillUnmount(){
    clearInterval(this.countdownId);
  }
}

class FormControlledElement extends React.Component {
  constructor (props){
    super(props);
    this.state = {
      inputValue: this.props.inputValue
    };
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleInputChange = this.handleInputChange.bind(this);
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
        <input type='text' value={this.state.inputValue} onChange={this.handleInputChange} ref={(input) => {this.inputEl = input}}/>
        <button type="submit" >Send</button>
      </form>
    );
  }
  // FormControlledElement 是採用 value 跟 onChange 的方法來取得 input 裡面的值
  // 但這個方法無法取得 input 這個 element 本身
  // 所以無法用 js 實現對於 input element 的各種操作
  // facebook 比較建議使用這個方法來寫

  // 這個範例嘗試將 FormUncontrolledElement 的 ref 寫進同一個 input DOM 裡面
  // 可以同時使用，暫時沒有發現其他問題

  handleInputChange(e){
    this.setState({
      inputValue: e.target.value
    });
    console.log(e.target.value);
  }

  handleSubmit(e){
    const v = this.state.inputValue;
    this.inputEl.style.backgroundColor = 'red'; //這行是在 FormControlledElement 中同時使用 FormUncontrolledElement 的實際範例
    console.log(v);
    e.preventDefault();
  }
}

class FormUncontrolledElement extends React.Component {
  constructor (props){
    super(props);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  render (){
    return (
      <form id="form-test" onSubmit={this.handleSubmit}>
        <input id="input-test" type="text" ref={(input) => {this.inputEl = input}} />
        <button type="submit" >Send</button>
      </form>
    );
  }
  // FormUncontrolledElement 的方法是採用 ref 來取得 input 這個 element
  // 再從抓到的 element 裡面監控 value 的數值

  // 反之 FormUncontrolledElement 就可以抓取到 input element
  // 進而對 input 進行操作
  // 例如這個範例是在 submit 的時候把背景色替換成紅色

  handleSubmit(e){
    const v = this.inputEl.value;
    console.log(v);
    this.inputEl.style.backgroundColor = 'red';
    this.inputEl.value = 'Submited';
    e.preventDefault();
  }

  componentDidMount(){
    // var tForm = $('#form-test');
    // var tInput = $('#input-test');
    //
    // tForm.submit(function(event) {
    //   tInput.val('submit');
    // });
    //不建議在 react 中使用 jquery 的方法
  }
}

class IfExpression extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      val: this.props.val
    }
  }

  render (){
    return (
      <div>
        {this.state.val > 0 &&
          <p>You have <span style={style}>{this.state.val}</span> messages.</p>}
      </div>
    );
  }
}

class IfElseExpression extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      val: this.props.val
    }
  }

  render(){
    return (
      <div>
        {this.state.val == 0 ? <p>You have no message.</p> :
          <p>You have <span style={style}>{this.state.val}</span> messages.</p>}
      </div>
    );
  }
}

class LoopExpression extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      list: G_list,
      isClass: this.props.isClass
    }
  }

  render() {
    return (
      <ul>
        {/* {this.state.list.map((m => <li key={m.id}>{m}</li>))}
        *   此寫法跟下方寫法功能相同
        */}
        {this.state.list.map(function(m){
        return <li key={m.id}>{m.text}</li>
        })}
      </ul>
    );
  }

  componentDidMount(){
    console.log(this.state.isClass);
  }
}
