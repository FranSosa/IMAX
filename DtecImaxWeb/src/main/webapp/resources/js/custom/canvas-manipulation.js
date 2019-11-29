var canvasMain,
    layerDrawCanvas,
    layerLengthCanvas,
    fabricCanvas,
    context,
    line,
    lineText,
    draw = false,
    pixelMM = 0.2645833333;

var CanvasManipulation = function(imagen, layerDraw, layerLength) {

    Caman(imagen, function () {

        this.render(function() {

            canvasMain = this.canvas;
            canvasMain.style.position = 'absolute';
            canvasMain.style.top = 0;
            canvasMain.style.left = 0;
            canvasMain.style.zIndex = 0;
            canvasMain.style.margin = '.5em 0';

            var canvasContainer = $('#canvas-container');

            canvasContainer.css('height', canvasMain.clientHeight + 13);

            Caman(layerDraw, function () {

                this.render(function() {

                    layerDrawCanvas = this.canvas;

                    layerDrawCanvas.style.width = canvasMain.clientWidth + 'px'
                    layerDrawCanvas.style.height = canvasMain.clientHeight + 'px';
                    layerDrawCanvas.style.position = 'absolute';
                    layerDrawCanvas.style.top = 0;
                    layerDrawCanvas.style.left = 0;
                    layerDrawCanvas.style.zIndex = -1;
                    layerDrawCanvas.style.margin = '.5em 0';
                    layerDrawCanvas.style.cursor = 'pointer';

                    Caman(layerLength, function () {

                        this.render(function() {

                            layerLengthCanvas = this.canvas;

                            layerLengthCanvas.style.width = canvasMain.clientWidth + 'px'
                            layerLengthCanvas.style.height = canvasMain.clientHeight + 'px';
                            layerLengthCanvas.style.position = 'absolute';
                            layerLengthCanvas.style.top = 0;
                            layerLengthCanvas.style.left = 0;
                            layerLengthCanvas.style.zIndex = -2;
                            layerLengthCanvas.style.margin = '0 0 0 -.5em';
                        });
                    });
                });
            });
        });
    });
};

CanvasManipulation.prototype.onLayerDraw = function() {

    this.offLayerLength();

    layerDrawCanvas.style.zIndex = 1;

    context = layerDrawCanvas.getContext("2d", { antialias: true });

    context.lineJoin = "round";

    this.addDrawListeners();
};

CanvasManipulation.prototype.offLayerDraw = function() {

    if (context) {

        context.clearRect(0, 0, (layerDrawCanvas.width / 2), (layerDrawCanvas.height / 2));

        context.closePath();
    }

    layerDrawCanvas.style.zIndex = -1;
};

CanvasManipulation.prototype.clearLayerDraw = function() {

    context.clearRect(0, 0, (layerDrawCanvas.width / 2), (layerDrawCanvas.height / 2));
};

CanvasManipulation.prototype.addDrawListeners = function() {

    var that = this;

    layerDrawCanvas.addEventListener('mousedown', function(oEvent) {

        draw = true;

        context.beginPath();

    }, false);

    layerDrawCanvas.addEventListener("mousemove", function(oEvent) {

        if (draw) {

            var mousePosition = that._mousePosition(layerDrawCanvas, oEvent);

            var color = $('input[id="imagenes-editar-form:draw-color_input"]').val();

            context.lineTo(mousePosition.x, mousePosition.y);

            context.strokeStyle = '#' + color;

            context.lineWidth = 0.6;

            context.stroke();
        }

    }, false);

    layerDrawCanvas.addEventListener('mouseup', function(oEvent) {

        draw = false;

    }, false);

    layerDrawCanvas.addEventListener("mouseout", function(oEvent) {

        draw = false;

    }, false);

};

CanvasManipulation.prototype.onLayerLength = function() {

    this.offLayerDraw();

    layerLengthCanvas.style.zIndex = 1;

    fabricCanvas = new fabric.Canvas('layer-length-editar',
        {
            selection: false,
            width: canvasMain.clientWidth,
            height: canvasMain.clientHeight,
            defaultCursor: 'cell'
        });

    this.addLengthListeners();
};

CanvasManipulation.prototype.offLayerLength = function() {

    if ((fabricCanvas) && (fabricCanvas.lowerCanvasEl)) {

        fabricCanvas.dispose();
    }

    layerLengthCanvas.style.zIndex = -2;
};

CanvasManipulation.prototype.clearLayerLength = function() {

    fabricCanvas.clear();
};

CanvasManipulation.prototype.addLengthListeners = function() {

    fabricCanvas.on('mouse:down', function(oEvent) {

        draw = true;

        var pointer = fabricCanvas.getPointer(oEvent.e);

        var points = [ pointer.x, pointer.y, pointer.x, pointer.y ];

        var color = $('input[id="imagenes-editar-form:length-color_input"]').val();

        line = new fabric.Line(points, {

            strokeWidth: 5,
            fill: '#' + color,
            stroke: '#' + color,
            originX: 'center',
            originY: 'center'
        });

        lineText = new fabric.Text('0', {
            fontSize: 22,
            fontFamily: 'Source Sans Pro',
            fill: '#' + color,
            stroke: '#' + color,
            originX: 'center'
        });

        fabricCanvas.add(line);
    });

    fabricCanvas.on('mouse:move', function(oEvent) {

        if (draw) {

            var that = this;

            var pointer = fabricCanvas.getPointer(oEvent.e);

            line.set({ x2: pointer.x, y2: pointer.y });

            lineText.set({
                text: Math.round(Math.sqrt(Math.pow(line.x2 - line.x1, 2) + Math.pow(line.y2 - line.y1, 2)) * pixelMM) + ' mm',
                top: pointer.y,
                left: pointer.x,
                originY: line.y1 < line.y2 ? 'top' : 'bottom'
            });

            fabricCanvas.add(lineText);

            fabricCanvas.renderAll();
        }
    });

    fabricCanvas.on('mouse:up', function(oEvent) {

        draw = false;
    });
};

CanvasManipulation.prototype._mousePosition = function(canvas, oEvent) {

    var ClientRect = canvas.getBoundingClientRect(),
        scaleX = (canvas.width / 2) / ClientRect.width,
        scaleY = (canvas.height / 2) / ClientRect.height;

    return {
        x: (oEvent.clientX - ClientRect.left) * scaleX,
        y: (oEvent.clientY - ClientRect.top) * scaleY
    }
};
