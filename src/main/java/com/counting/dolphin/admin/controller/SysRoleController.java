package com.counting.dolphin.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.counting.dolphin.admin.domain.SysRole;
import com.counting.dolphin.admin.domain.SysUser;
import com.counting.dolphin.admin.domain.bo.RoleUserBo;
import com.counting.dolphin.admin.service.SysRoleService;
import com.counting.dolphin.common.api.R;
import com.counting.dolphin.constant.ApiLog;
import com.counting.dolphin.constant.BusinessType;
import com.counting.dolphin.constant.OperatorType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/sys/role")
public class SysRoleController {

    @Resource
    private SysRoleService sysRoleService;

    @ApiLog(title = "角色管理", businessType = BusinessType.QUERY, operatorType = OperatorType.MANAGE)
    @GetMapping(value = "/query/page")
    public R<IPage<SysRole>> querySysRolePage(@RequestParam(value = "current", required = true, defaultValue = "1") Integer current, @RequestParam(value = "size", required = true, defaultValue = "10") Integer size, @RequestParam(value = "roleName", required = false) String roleName) {
        return R.data(sysRoleService.querySysUserPage(current, size, roleName));
    }

    @GetMapping(value = "/query/page/in/user")
    public R<IPage<SysUser>> querySysUserInRoleIdPage(@RequestParam(value = "current", required = true, defaultValue = "1") Integer current, @RequestParam(value = "size", required = true, defaultValue = "10") Integer size, @RequestParam(value = "roleId") String roleId) {
        return R.data(sysRoleService.querySysUserInRoleIdPage(current, size, roleId));
    }

    @GetMapping(value = "/query/page/un/user")
    public R<IPage<SysUser>> querySysUserUnRoleIdPage(@RequestParam(value = "current", required = true, defaultValue = "1") Integer current, @RequestParam(value = "size", required = true, defaultValue = "10") Integer size, @RequestParam(value = "roleId") String roleId, @RequestParam(value = "username", required = false) String username) {
        return R.data(sysRoleService.querySysUserUnRoleIdPage(current, size, roleId, username));
    }

    @ApiLog(title = "角色管理", businessType = BusinessType.DELETE, operatorType = OperatorType.MANAGE)
    @GetMapping(value = "/remove")
    public R removeSysRole(@RequestParam(value = "roleId") String roleId) {
        return R.status(sysRoleService.removeSysRole(roleId));
    }

    @ApiLog(title = "角色人员", businessType = BusinessType.GRANT, operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/create/acl/user")
    @ResponseBody
    public R createAclUserRole(@RequestBody RoleUserBo roleUserBo) {
        return R.status(sysRoleService.createAclUserRole(roleUserBo));
    }

    @ApiLog(title = "角色管理", businessType = BusinessType.INSERT, operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/createOrUpdate")
    @ResponseBody
    public R createSysRole(@RequestBody SysRole sysRole) {
        return R.status(sysRoleService.createSysRole(sysRole));
    }

    @GetMapping(value = "/detail")
    public R<SysRole> sysSysRoleDetail(@RequestParam(value = "roleId") String roleId) {
        return R.data(sysRoleService.sysSysRoleDetail(roleId));
    }
    @ApiLog(title = "角色菜单", businessType = BusinessType.GRANT, operatorType = OperatorType.MANAGE)
    @PostMapping(value = "/acl")
    public R sysSysRoleAcl(@RequestBody SysRole sysRole) {
        return R.data(sysRoleService.sysSysRoleAcl(sysRole));
    }

    @ApiLog(title = "角色人员", businessType = BusinessType.DELETE, operatorType = OperatorType.MANAGE)
    @GetMapping(value = "/remove/user")
    public R removeSysUserRoleAcl(@RequestParam("userId") String userId, @RequestParam("roleId") String roleId) {
        return R.status(sysRoleService.removeSysUserRoleAcl(userId, roleId));
    }

    @ApiLog(title = "角色状态", businessType = BusinessType.UPDATE, operatorType = OperatorType.MANAGE)
    @GetMapping(value = "/modify/status")
    public R modifyRoleStatus(@RequestParam(value = "roleId") String roleId, @RequestParam(value = "status") String status) {
        return R.data(sysRoleService.modifyRoleStatus(roleId, status));
    }
}