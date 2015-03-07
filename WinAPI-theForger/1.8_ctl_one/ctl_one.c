#include <windows.h>
#include "resource.h"

BOOL CALLBACK DlgProc(HWND hwnd, UINT Message, WPARAM wParam, LPARAM lParam)
{
	switch (Message)
	{
		case WM_INITDIALOG:
			SetDlgItemText(hwnd, IDC_TEXT, "This is a string");
			SetDlgItemInt(hwnd, IDC_NUMBER, 5, FALSE);
			break;
		case WM_COMMAND:
			switch (LOWORD(wParam))
			{
				case IDC_ADD:
				{
					BOOL bSuccess;
					int nTimes = GetDlgItemInt(hwnd, IDC_NUMBER, &bSuccess, FALSE);
					if (bSuccess)
					{
						int len = GetWindowTextLength(GetDlgItem(hwnd, IDC_TEXT));
						if (len > 0)
						{
							int i;
							char *buf;

							buf = (char*)GlobalAlloc(GPTR, len + 1);
							GetDlgItemText(hwnd, IDC_TEXT, buf, len + 1);

							for (i = 0; i < nTimes; i++)
							{
								int index = SendDlgItemMessage(hwnd, IDC_LIST, LB_ADDSTRING, 0, (LPARAM)buf);
								SendDlgItemMessage(hwnd, IDC_LIST, LB_SETITEMDATA, (WPARAM)index, (LPARAM)nTimes);
							}
							GlobalFree((HANDLE)buf);
						}
						else
							MessageBox(hwnd, "You didn't enter anything!", "Warning", MB_OK);
					}
					else
						MessageBox(hwnd, "Couldn't translate that number :(", "Warning", MB_OK);
					break;
				}
				case IDC_REMOVE:
				{
					HWND hList = GetDlgItem(hwnd, IDC_LIST);
					int count = SendMessage(hList, LB_GETSELCOUNT, 0, 0);
					if (count != LB_ERR)
					{
						if (count != 0)
						{
							int i;
							int *buf = (int *)GlobalAlloc(GPTR, sizeof(int) * count);
							SendMessage(hList, LB_GETSELITEMS, (WPARAM)count, (LPARAM)buf);
							for (i = count - 1; i >= 0; i--)
								SendMessage(hList, LB_DELETESTRING, (WPARAM)buf[i], 0);
							GlobalFree(buf);
						}
						else
							MessageBox(hwnd, "No items selected.", "Warning", MB_OK);
					}
					else
						MessageBox(hwnd, "Error count items :(", "Warning", MB_OK);
					break;
				}
				case IDC_CLEAR:
					SendDlgItemMessage(hwnd, IDC_LIST, LB_RESETCONTENT, 0, 0);
					break;
				case IDC_LIST:
					switch (HIWORD(wParam))
					{
						case LBN_SELCHANGE:
						{
							HWND hList = GetDlgItem(hwnd, IDC_LIST);
							int count = SendMessage(hList, LB_GETSELCOUNT, 0, 0);
							if (count != LB_ERR)
							{
								if (count == 1)
								{
									int index;
									int err = SendMessage(hList, LB_GETSELITEMS, (WPARAM)1, (LPARAM)&index);
									if (err != LB_ERR)
									{
										int data = SendMessage(hList, LB_GETITEMDATA, (WPARAM)index, 0);
										SetDlgItemInt(hwnd, IDC_SHOWCOUNT, data, FALSE);
									}
								}
							}
							else
								MessageBox(hwnd, "Error counting items :(", "Warning", MB_OK);
						}
					}
					break;
			}
			break;
		case WM_CLOSE:
			EndDialog(hwnd, 0);
			break;
		default:
			return FALSE;
	}
	return TRUE;
}

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nCmdShow)
{
	return DialogBox(hInstance, MAKEINTRESOURCE(IDD_MAIN), NULL, DlgProc);
}
