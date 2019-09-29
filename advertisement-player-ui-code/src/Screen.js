import React, {Component} from 'react';

export class Screen extends Component {
    render() {
        const panelStyle = {
            background: this.props.data.colour
        };

        return (
            <section className="wrapper">
                <Panel
                    data={this.props.data}
                    panelStyle={panelStyle}
                />
            </section>
        );
    }
}

class Panel extends React.Component {

    render() {
        const screenId= this.props.data.screenId;
        if(screenId === 4){
        const wrapperStyle = {
            // backgroundImage: `url('${this.props.data.img}')`
            content: `url('${this.props.data.img}')`,
            height: "100%",
            width: "100%"
        };
        
        return (
            <aside className="panel" style={this.props.panelStyle}>
                <h2 className="panel-header">{this.props.data.header}</h2>
                <p className="panel-info">{this.props.data.body}</p>
                <div style={wrapperStyle}/>
            </aside>
        );
    }
    else{
        const wrapperStyle = {
            content: `url('https://s3.us-east-2.amazonaws.com/advertise-content/1569656916857-common.jpg')`,
            position: "fixed",
            top: "0",
            left: "0",
            width: "100%",
            height: "100%"
        };
        return (
            <aside className="panel" style={this.props.panelStyle}>
                <h2 className="panel-header">For Digital Experience in Advertisement.</h2>
                <p className="panel-info">Contact Us</p>
                <div style={wrapperStyle}/>
            </aside>
        );
    }
}
}
