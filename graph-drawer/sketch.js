var graph = new Graph();
var nodeA = new Node("A");
var nodeB = new Node("B");
var nodeC = new Node("C");
var nodeD = new Node("D");
graph.addNode(nodeD)
graph.addNeighbors(nodeA, nodeB);
graph.addNeighbors(nodeB, nodeA);
graph.addNeighbors(nodeC, nodeB);
graph.addNeighbors(nodeC, nodeA);

function setup(){
    createCanvas(500,500);
    background(200);
    
    // draw points first
    var nodeKeys = Object.keys(graph.nodes);
    for(let i = 0; i < nodeKeys.length; i++){
        let nodeKey = nodeKeys[i];
        randomPoint(graph.nodes[nodeKey]);
    }

    // connect lines
    let neighborsKeys = Object.keys(graph.neighbors);
    for (let i = 0; i < neighborsKeys.length; i++){ 
        
        node = graph.nodes[neighborsKeys[i]];
        neighbors = graph.getNeighbors(neighborsKeys[i]);

        if (neighbors != undefined){
            for (let i = 0; i < neighbors.length; i++){
                connectCircles(node, neighbors[i]);
            }
        }

    }

    // draw circles
    var nodeKeys = Object.keys(graph.nodes);
    for(let i = 0; i < nodeKeys.length; i++){
        let nodeKey = nodeKeys[i];
        drawCircle(graph.nodes[nodeKey]);
    }
    
}

function draw(){
    
}

function drawCircle(node){
    fill(255);
    let x = node.xPos;
    let y = node.yPos;
    ellipseMode(CENTER);
    ellipse(x, y, 30, 30);
    fill(0);
    textAlign(CENTER, CENTER);
    text(node.value, x, y);
}

function randomPoint(node){
    let x = Math.floor(Math.random() * 400) + 100;
    let y = Math.floor(Math.random() * 400) + 100;
    node.xPos = x; // set the x and y of node object
    node.yPos = y;
    point(x,y);
}

function connectCircles(node1, node2){
    line(node1.xPos, node1.yPos, node2.xPos, node2.yPos);

    riseDistance = (node1.yPos - node2.yPos);
    runDistance = (node1.xPos - node2.xPos);

    // point on the line
    p1X = node2.xPos + (runDistance/4)
    p1Y = node2.yPos + (riseDistance/4)

    //can convert to an equation and x as pixel coordinates
    
    invertedRise = -(node1.xPos - node2.xPos);
    invertedRun = (node1.yPos - node2.yPos);

    // point down the line
    newP1X = p1X + (runDistance/45);
    newP1Y = p1Y + (riseDistance/45);
    
    // point on the right
    p2X = newP1X + invertedRun/50;
    p2Y = newP1Y + invertedRise/50;
    // point on the left
    p3X = newP1X - invertedRun/50;
    p3Y = newP1Y - invertedRise/50;
    fill(0);
    triangle(p1X,p1Y,p2X,p2Y,p3X,p3Y)
    

}