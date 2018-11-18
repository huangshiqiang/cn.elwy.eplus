//导入工具包 require('node_modules里对应模块')
var gulp = require('gulp'); // 本地安装gulp所用到的地方
var rename = require('gulp-rename');
var less = require('gulp-less');
var minifyCSS = require('gulp-minify-css');

// 定义一个css编译任务
gulp.task('css', function() {
	gulp.src([ 'src/less/skins/all-skins.less', 'src/less/webplus.less' ]) // 该任务针对的文件
	.pipe(less()) // 编译less文件
	.pipe(gulp.dest('dist/css')) // 输出css文件
	.pipe(minifyCSS()) // 压缩css文件
	.pipe(rename({
		suffix : '.min'
	})) // 重命名css文件
	.pipe(gulp.dest('dist/css')); // 输出压缩后的css文件
});

gulp.task('default', [ 'css' ]); // 定义默认任务












//多個css文件同時壓縮
/*gulp.task('css',function(){  
 gulp.src('css_dev/*.css')  
     .pipe(clean_css())  
     .pipe(rename({suffix: '.min'}))  
     .pipe(gulp.dest('css'))  
})  */




/*var gulp = require('gulp'),
    // sass = require('gulp-sass'),
    concat = require('gulp-concat'),
    // minifycss = require('gulp-minify-css'),
    uglify = require('gulp-uglify'),
    rename = require('gulp-rename');
    // autoprefixer = require('gulp-autoprefixer');

     gulp.task('default',['scripts']);


    gulp.task('scripts', function() {
    gulp.src([
        'resource/js/module/myFileJs/audit_list.js',
        'resource/js/module/myFileJs/finalsales.js',
        'resource/js/module/myFileJs/subject.js'
    ])
        .pipe(concat('app.js'))         // 合并为一个文件
        .pipe(gulp.dest('dist/js'))   // 写入一份到指定目录
        .pipe(uglify())                 // 压缩一份
        .pipe(rename("buldle.min.js"))  // 并重命名以防覆盖上次写入的文件
        .pipe(gulp.dest('dist/js'));  // 写入到指定目录
});*/