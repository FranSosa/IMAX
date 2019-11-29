var ImagesManipulation = function() { };

ImagesManipulation.prototype.brightness = function() {

    this._manipulate();
};

ImagesManipulation.prototype.contrast = function() {

    this._manipulate();
};

ImagesManipulation.prototype.exposure = function() {

    this._manipulate();
};

ImagesManipulation.prototype.hue = function() {

    this._manipulate();
};

ImagesManipulation.prototype.noise = function() {

    this._manipulate();
};

ImagesManipulation.prototype.saturation = function() {

    this._manipulate();
};

ImagesManipulation.prototype.sepia = function() {

    this._manipulate();
};

ImagesManipulation.prototype.vibrance = function() {

    this._manipulate();
};

ImagesManipulation.prototype.clip = function() {

    this._manipulate();
};

ImagesManipulation.prototype.gamma = function() {

    this._manipulate();
};

ImagesManipulation.prototype._manipulate = function() {

    var canvasImage = document.getElementById("imagenes-editar-form:imagen-editar");

    Caman(canvasImage, function () {

        this.revert(false);

        this.brightness(parseInt($('#imagenes-editar-form\\:brightness').val()));

        this.contrast(parseInt($('#imagenes-editar-form\\:contrast').val()));

        this.exposure(parseInt($('#imagenes-editar-form\\:exposure').val()));

        this.hue(parseInt($('#imagenes-editar-form\\:hue').val()));

        this.noise(parseInt($('#imagenes-editar-form\\:noise').val()));

        this.saturation(parseInt($('#imagenes-editar-form\\:saturation').val()));

        this.sepia(parseInt($('#imagenes-editar-form\\:sepia').val()));

        this.vibrance(parseInt($('#imagenes-editar-form\\:vibrance').val()));

        this.clip(parseInt($('#imagenes-editar-form\\:clip').val()));

        this.gamma(parseInt($('#imagenes-editar-form\\:gamma').val()));

        this.render();
    });
};
