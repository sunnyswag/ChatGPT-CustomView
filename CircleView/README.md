# 当 ChatGPT 遇上自定义圆环进度条：一场视觉盛宴的诞生



## 勇敢的挑战：诞生一个自定义圆环进度条 View

我像往常一样，在网上冲浪。一则评论引起了我的注意，评论来自 [Android自定义 View 圆环的绘制](https://juejin.cn/post/7164593975255531557#comment)

> ChatGPT 可以写出自定义 view 么

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/image-20230422161039297.png" alt="image-20230422161039297" style="zoom:33%;" />

作者写的自定义 View ，效果是这样的：

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/eae1eca72fc1416784b2e7c42ee6638c~tplv-k3u1fbpfcp-zoom-crop-mark:2268:2268:2268:1277.awebp" alt="Android自定义View的绘制，往往都是从圆环开始" style="zoom: 25%;" />

说实话，看起来有一点点复杂。不过以我这几个月和 ChatGPT 的相处，我对它的实力还是有信心的。写个自定义 View 应该不成问题。不过我也很好奇结果会是咋样，毕竟没有试过。那就废话不多说，直接开始！

上 Prompt，(基本上是参照作者的实现用语言翻译了一遍)：

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/image-20230422161458486.png" alt="image-20230422161458486" style="zoom:33%;" />

几秒之后，代码写好了，赶紧打开 AS 新建工程跑了起来，效果是这样的：

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/image-20230422162044043.png" alt="image-20230422162044043" style="zoom:33%;" />

额，差距有点大。不过，我也不能怪它，毕竟我说的好像就是这个效果。



## 将魔法注入 XML：颜色配置之道

代码初始化完成了，但是为了让自定义圆环进度条 View 更加灵活易用，我们决定将颜色属性放入 XML 文件。借助`context.obtainStyledAttributes()` 的魔法，我们从 `AttributeSet` 中获取了相关颜色配置。

总之，操作之后，代码看起来更加舒服了，简单摘录一下这部分的对话内容：

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/image-20230422162843738.png" alt="image-20230422162843738" style="zoom:33%;" />



## 细节至上：样式微调的艺术

接下来就是一些对齐 “设计稿” 的操作了，我自己手动调整了颜色，文字大小，圆环大小等。碰到不清楚的，就问它。

关于阴影设置和圆角圆圈相关的问答：

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/image-20230422163743111.png" alt="image-20230422163743111" style="zoom:33%;" />

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/image-20230422163916484.png" alt="image-20230422163916484" style="zoom:33%;" />

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/image-20230422164114230.png" alt="image-20230422164114230" style="zoom:33%;" />

不清楚的地方也就阴影和画笔圆角这两部分，其他的代码多少都有所了解，可以自己尝试着改改。如果你对自定义 View 不是很清楚，问它问题，相信它也能很完美的回答上来。

调整完之后的效果，和 “设计稿” 大差不差了：

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/image-20230422164731951.png" alt="image-20230422164731951" style="zoom: 50%;" />



## 让圆环动起来：百分比动画的奥秘

一场视觉盛宴当然离不开动画效果。为了让圆环进度条更加生动有趣，我们使用了 `ValueAnimator` 为进度弧添加了动画效果。通过创建一个平滑过渡的动画，我们让进度弧在短短一秒钟内呈现出吸引人的变化。

为了简单起见，我直接把我的代码 copy 给了它：

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/image-20230422165115550.png" alt="image-20230422165115474" style="zoom:50%;" />

它的回答也很准确，这里涉及到多个变量(出勤率的百分比，圆环的百分比)的变化，用 ValueAnimator 会更加合适。

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/image-20230422165205062.png" alt="image-20230422165205062" style="zoom: 46.5%;" />

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/image-20230422165235037.png" alt="image-20230422165235037" style="zoom:50%;" />

花费的时间并没有多久，整体的效果已经完美还原了。说实话，如果是让我自己写出来，确实是没问题的。无非是需要花费更多时间而已。ChatGPT 和我一起写，大概花费 2h 的工作量。参考技术博客去写，大概需要 0.5d ~ 1d 吧，而且过程想想就会比较痛苦(毕竟是自定义 View)。

如下是最终的效果：

<img src="https://tern-1257001564.cos.ap-guangzhou.myqcloud.com/markdown_pic/circle_custom_view.gif" alt="circle_custom_view" style="zoom:33%;" />



## 最后的最后

GPT-4 写自定义 View，完全是没问题的。GPT-3.5 我不知道，没有尝试过，感兴趣的朋友也可以试试。

要是在几个月之后，GPT-4 开放了图片上传的接口，那可以预见的是，可以时间 Figma 设计稿 -> UI Code Any Platform。

人类会被 GPT 淘汰吗？我感觉不学习的人会被淘汰。

就我自己和 ChatGPT 对话的体验来说，学习知识，简直是一种享受。它就像一个什么都懂的高手，在用你能接受的知识的层次，你能理解的语言，来回答你的问题。这比去网上看大佬的技术博客来的学的快多了。具体得自行体验才能感受到。

非常期待 GPT 以后的发展，让人类从当前繁杂的劳动中脱离出来，(然后进入到另一个充满繁重劳动的领域 :-)。



## REFERENCE

[和 ChatGPT的对话详情(后面一部分的代码在导出为图片时被吃掉了)](https://github.com/sunnyswag/ChatGPT-CustomView/blob/main/assets/custom_view_chat.png)

[Android自定义View的绘制，往往都是从圆环开始](https://juejin.cn/post/7164593975255531557#comment)
