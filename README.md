计算机毕设-基于SpringBoot+Vue仓库管理系统（接毕设）  
项目演示地址：https://www.bilibili.com/video/BV1p46AYWE6j/?spm_id_from=333.337.search-card.all.click&vd_source=b648d6736b802d4ea0613920edef4754  
项目文件(源码+文档+ppt+视频讲解 需要+V:HMbishe)  
研究内容  
本系统的研究目标是设计并制作一个SpringBoot的仓库管理系统应用，将实现仓库员跟管理员两部分，主要实现以下功能模块。分别为：  
1注册登录功能  
仓库员登录系统需要注册账号信息，仓库员点击注册按钮输入的员工编号、输入账号密码等信息之后点击确定按钮完成信息注册，系统会验证员工编号是否以及注册过，如果注册过或者信息错误会弹出报错弹框。注册成功之后管理员对仓库员进行审核，审核通过之后仓库员输入员工编号、账号完成系统登录，系统会根据仓库员输入的账号信息进行判空验证以及验证账号信息、账号密码是否正确，如果账号密码出现错误，系统会弹出报错弹框。  
2用户管理功能  
用户管理模块包括仓库列表和管理员列表两个部分，管理员可以在仓库员列表根据姓名、员工编号进行过滤查看仓库员信息，审核仓库员注册的账号信息、修改和删除仓库员信息，管理员也可以在管理员列表查看管理员信息以及审核新注册的管理员账号信息。  
3库存管理功能  
管理员在库存管理模块可以录入、修改、删除物品信息，查看物品出库记录、入库记录以及查看物品库存信息，管理员还可以打印物品库存信息。  
4入库管理功能  
仓库员登记物品入库信息，登记物品入库信息之后，物品库存会自动刷新，管理员可以在入库管理模块查看物品入库信息以及打印物品入库Excel报表。  
5出库管理功能  
仓库员登记物品出库信息，登记物品出库信息之后，物品库存会自动刷新，管理员可以在出库管理模块查看物品出库信息以及打印物品出库Excel报表。  
6系统管理功能  
管理员可以在系统管理模块查看系统菜单信息，新增系统菜单功能然后分配对应的系统权限，管理员点击新增主菜单功能，然后点击子菜单功能，选择对应的主菜单，输入子菜单名字、菜单路劲、菜单排序、所属角色等信息之后完成菜单新增，管理员还可以对系统菜单进行修改、删除等操作。  
功能结构图：  
<img width="692" height="452" alt="image" src="https://github.com/user-attachments/assets/4a0fd20b-10bb-410c-af39-d2dfdbb0e009" />  
界面截图：  
<img width="692" height="317" alt="image" src="https://github.com/user-attachments/assets/365fce29-7e89-4cd4-8626-e027ab22adbf" />  
<img width="692" height="312" alt="image" src="https://github.com/user-attachments/assets/947b31cc-a1bc-46c6-b76a-a88e81103507" />  
<img width="692" height="254" alt="image" src="https://github.com/user-attachments/assets/61f5cff9-c7e9-4672-bebb-0f37e27d2197" />  
<img width="692" height="245" alt="image" src="https://github.com/user-attachments/assets/e0ace51f-f283-4800-8273-1116a716bdc8" />  
<img width="692" height="372" alt="image" src="https://github.com/user-attachments/assets/23f21728-cf84-4a44-ae64-6bb84f3a9fa0" />  
<img width="692" height="315" alt="image" src="https://github.com/user-attachments/assets/376fe0a6-98f8-4a2e-90c0-1bf6864d6895" />  
<img width="692" height="321" alt="image" src="https://github.com/user-attachments/assets/b2872b24-d78f-44ac-bd4a-088804bca36d" />  
<img width="691" height="312" alt="image" src="https://github.com/user-attachments/assets/e08cc99f-0ab8-4732-a6b4-6d026f2e8c61" />  
<img width="692" height="318" alt="image" src="https://github.com/user-attachments/assets/ac05215d-72ff-4f55-900f-f08f11488600" />  
<img width="691" height="343" alt="image" src="https://github.com/user-attachments/assets/21906e1c-7ec3-4f4b-ab36-a0a0c98703ed" />  












